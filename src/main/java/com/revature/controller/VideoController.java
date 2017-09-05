package com.revature.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.VideoService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.utils.RestURIConstants;
import com.revature.utils.ServiceConstants;
import com.revature.utils.ServiceResponseUtils;
import com.revature.vo.HttpStatusResponse;
import com.revature.vo.VideoVO;

/**
 * This controller used to do all operation related to video.
 */
@RestController
@RequestMapping("/")
public class VideoController {
  private static final Logger logger = Logger.getLogger(VideoController.class);
  @Autowired
  private VideoService videoService;

  /**
   * To get active videos
   * 
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = RestURIConstants.GET_VIDEOS, method = RequestMethod.GET)
  public ResponseEntity<HttpStatusResponse> getQuizzes() {
    try {
      List<VideoVO> videos = videoService.doGetVideos();
      return Optional.ofNullable(videos).filter(CollectionUtils::isNotEmpty).map(
          video -> new ResponseEntity<>(ServiceResponseUtils.setHttpResponse(HttpStatus.OK.value(),
              ServiceConstants.DATA_RETRIEVAL_SUCCESS_MESSAGE, video), HttpStatus.OK))
          .orElse(
              new ResponseEntity<>(
                  ServiceResponseUtils.setHttpResponse(HttpStatus.NO_CONTENT.value(),
                      ServiceConstants.NO_RECORDS_FOUND_ERROR_MESSAGE, null),
                  HttpStatus.NO_CONTENT));
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(
          ServiceResponseUtils.setHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
              ServiceConstants.DATA_RETRIEVAL_FAILED_MESSAGE, null),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
