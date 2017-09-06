package com.revature.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.collections4.CollectionUtils;

import com.revature.biz.CurriculumService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.utils.ServiceConstants;
import com.revature.utils.ServiceResponseUtils;
import com.revature.vo.CurriculumVO;
import com.revature.vo.HttpStatusResponse;


@RestController
@RequestMapping("/curriculums")
public class CurriculumController {

  private static Logger log = Logger.getLogger(CurriculumController.class);

  @Autowired
  private CurriculumService curriculamService;



  @RequestMapping("/save")
  public String scheduleEmail() throws Exception {
    curriculamService.saveCurriculam();
    return "success";
  }

  // listing all curriculums
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<HttpStatusResponse> getAllCurriculum() {
    List<CurriculumVO> curriculum = new ArrayList<>();
    try {
      curriculum = curriculamService.doGetAllCurriculums();
      return Optional.ofNullable(curriculum).filter(CollectionUtils::isNotEmpty).map(
          curriclm -> new ResponseEntity<>(ServiceResponseUtils.setHttpResponse(HttpStatus.OK.value(),
              ServiceConstants.DATA_RETRIEVAL_SUCCESS_MESSAGE, curriclm), HttpStatus.OK))
          .orElse(
              new ResponseEntity<>(
                  ServiceResponseUtils.setHttpResponse(HttpStatus.NO_CONTENT.value(),
                      ServiceConstants.NO_RECORDS_FOUND_ERROR_MESSAGE, null),
                  HttpStatus.NO_CONTENT));
    } catch (BusinessServiceException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>(
          ServiceResponseUtils.setHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
              ServiceConstants.DATA_RETRIEVAL_FAILED_MESSAGE, null),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // in-activating/activating the curriculum
  @RequestMapping(value = "/{curriculumId:[\\d]+}/status/{status:[0-1]}",
      method = RequestMethod.PUT)
  public ResponseEntity<HttpStatusResponse> updateCurriculumStatus(
      @PathVariable("curriculumId") Long curriculumId, @PathVariable("status") boolean status) {
    HttpStatusResponse response = new HttpStatusResponse();
    try {
      curriculamService.doUpdateCurriculumStatus(curriculumId, status);
      response.setStatusCode(HttpStatus.OK.value());
      response.setDescription("Curriculum Status Updated Successfully");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (BusinessServiceException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>(
          ServiceResponseUtils.setHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
              ServiceConstants.DATA_UPDATE_FAILED_MESSAGE, null),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
  }

}
