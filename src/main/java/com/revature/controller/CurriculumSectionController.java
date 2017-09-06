package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CurriculumSectionService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.CurriculumSection;
import com.revature.utils.ServiceConstants;
import com.revature.utils.ServiceResponseUtils;
import com.revature.vo.HttpStatusResponse;
import com.revature.vo.ServiceResponse;

@RestController
@RequestMapping("/curriculum/section")
public class CurriculumSectionController {
  private static final Logger logger = Logger.getLogger(CurriculumSectionController.class);
  @Autowired
  public CurriculumSectionService curriculumSectionService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseEntity<HttpStatusResponse> getAllCurriculumSections() {
    HttpStatusResponse response = new HttpStatusResponse();
    ServiceResponse serviceResponse = new ServiceResponse();
    List<CurriculumSection> curriculumSections = new ArrayList<>();
    try {
      curriculumSections = curriculumSectionService.doGetAllCurriculumSections();
      if (CollectionUtils.isNotEmpty(curriculumSections)) {
        response.setStatusCode(HttpStatus.OK.value());
        response.setDescription("Curriculum Sections Retrieved Successfully");
        response.setData(curriculumSections);
        return new ResponseEntity<>(response, HttpStatus.OK);
      } else {
        response.setStatusCode(HttpStatus.NO_CONTENT.value());
        response.setDescription("No records found");
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
      }
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<HttpStatusResponse> getCurriculumSectionById(@PathVariable("id") Long id) {
    HttpStatusResponse response = new HttpStatusResponse();
    List<CurriculumSection> curriculumSections = new ArrayList<>();
    try {
      curriculumSections = curriculumSectionService.doGetCurriculumSectionById(id);
      if (CollectionUtils.isNotEmpty(curriculumSections)) {
        response.setStatusCode(HttpStatus.OK.value());
        response.setDescription("Curriculum Sections Retrieved Successfully");
        response.setData(curriculumSections);
        return new ResponseEntity<>(response, HttpStatus.OK);
      } else {
        response.setStatusCode(HttpStatus.NO_CONTENT.value());
        response.setDescription("No records found");
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
      }
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ResponseEntity<HttpStatusResponse> saveCurriculumSection(
      @RequestBody CurriculumSection curriculumSection) {
    HttpStatusResponse response = new HttpStatusResponse();
    try {
      curriculumSectionService.doSaveCurriculumSection(curriculumSection);
      response.setStatusCode(HttpStatus.OK.value());
      response.setDescription("Curriculum Section Saved Successfully");
      response.setData("");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(
          ServiceResponseUtils.setHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
              ServiceConstants.DATA_RETRIEVAL_FAILED_MESSAGE, null),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<HttpStatusResponse> updateCurriculumSection(
      @RequestBody CurriculumSection curriculumSection) {
    HttpStatusResponse response = new HttpStatusResponse();
    try {
      curriculumSectionService.doUpdateCurriculumSection(curriculumSection);
      response.setStatusCode(HttpStatus.OK.value());
      response.setDescription("Curriculum Section updated Successfully");
      response.setData("");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/{id}/display-order/{dis-order}", method = RequestMethod.PUT)
  public ResponseEntity<HttpStatusResponse> updateCurriculumSectionDisplayOrder(
      @PathVariable("id") Long id, @PathVariable("dis-order") Integer displayOrder) {
    HttpStatusResponse response = new HttpStatusResponse();
    try {
      CurriculumSection curriculumSection = new CurriculumSection();
      curriculumSection.setId(id);
      curriculumSection.setDisplayOrder(displayOrder);
      curriculumSectionService.doUpdateCurriculumSectionDisplayOrder(curriculumSection);
      response.setStatusCode(HttpStatus.OK.value());
      response.setDescription("Curriculum Section Display Order updated Successfully");
      response.setData("");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<HttpStatusResponse> deleteCurriculumSection(@PathVariable("id") Long id) {
    HttpStatusResponse response = new HttpStatusResponse();
    try {
      CurriculumSection curriculumSection = new CurriculumSection();
      curriculumSection.setId(id);
      curriculumSectionService.doDeleteCurriculumSection(curriculumSection);
      response.setStatusCode(HttpStatus.OK.value());
      response.setDescription("Curriculum Section Deleted Successfully");
      response.setData("");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
