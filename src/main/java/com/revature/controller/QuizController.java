package com.revature.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.utils.RestURIConstants;
import com.revature.utils.ServiceResponseUtils;
import com.revature.vo.HttpStatusResponse;
import com.revature.vo.QuizVO;

/**
 * This controller used to do all operation related to quiz.
 */
@RestController
@RequestMapping("/")
public class QuizController {
  private static final Logger logger = Logger.getLogger(QuizController.class);
  @Autowired
  private QuizService quizService;

  /**
   * To get active quizzes
   * 
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = RestURIConstants.GET_QUIZZES, method = RequestMethod.GET)
  public ResponseEntity<HttpStatusResponse> getQuizzes() {
    try {
      List<QuizVO> quizzes = quizService.doGetQuizzes();
      if (CollectionUtils.isNotEmpty(quizzes)) {
        return new ResponseEntity<>(ServiceResponseUtils.setHttpResponse(HttpStatus.OK.value(),
            "Data retrived successfully", quizzes), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(ServiceResponseUtils.setHttpResponse(
            HttpStatus.NO_CONTENT.value(), "No records founds", null), HttpStatus.NO_CONTENT);
      }
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
