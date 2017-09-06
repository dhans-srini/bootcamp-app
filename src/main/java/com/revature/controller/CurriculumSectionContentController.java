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

import com.revature.biz.CurriculumSectionContentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.CurriculumSectionContent;
import com.revature.vo.HttpStatusResponse;

@RestController
@RequestMapping("/curriculum/section/content")
public class CurriculumSectionContentController {
	private static final Logger logger = Logger.getLogger(CurriculumSectionContentController.class);
	@Autowired
	public CurriculumSectionContentService curriculumSectionContentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<HttpStatusResponse> getAllCurriculumSectionContents() {
		HttpStatusResponse response = new HttpStatusResponse();
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			curriculumSectionContents = curriculumSectionContentService.doGetAllCurriculumSectionContents();
			if (CollectionUtils.isNotEmpty(curriculumSectionContents)) {
				response.setStatusCode(HttpStatus.OK.value());
				response.setDescription("Curriculum Section Contents Retrieved Successfully");
				response.setData(curriculumSectionContents);
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
	public ResponseEntity<HttpStatusResponse> getAllCurriculumSectionContentsById(@PathVariable("id") Long id) {
		HttpStatusResponse response = new HttpStatusResponse();
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			curriculumSectionContents = curriculumSectionContentService.doGetCurriculumSectionContentById(id);
			if (CollectionUtils.isNotEmpty(curriculumSectionContents)) {
				response.setStatusCode(HttpStatus.OK.value());
				response.setDescription("Curriculum Section Contents Retrieved Successfully");
				response.setData(curriculumSectionContents);
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
	public ResponseEntity<HttpStatusResponse> saveCurriculumSectionContent(
			@RequestBody CurriculumSectionContent curriculumSectionContent) {
		HttpStatusResponse response = new HttpStatusResponse();
		try {
			curriculumSectionContentService.doSaveCurriculumSectionContent(curriculumSectionContent);
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Section Content Saved Successfully");
			response.setData("");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<HttpStatusResponse> updateCurriculumSectionContent(
			@RequestBody CurriculumSectionContent curriculumSectionContent) {
		HttpStatusResponse response = new HttpStatusResponse();
		try {
			curriculumSectionContentService.doUpdateCurriculumSectionContent(curriculumSectionContent);
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Section Content updated Successfully");
			response.setData("");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}/display-order/{dis-order}", method = RequestMethod.PUT)
	public ResponseEntity<HttpStatusResponse> updateCurriculumSectionContentDisplayOrder(@PathVariable("id") Long id,
			@PathVariable("dis-order") Integer displayOrder) {
		HttpStatusResponse response = new HttpStatusResponse();
		try {
			CurriculumSectionContent curriculumSectionContent = new CurriculumSectionContent();
			curriculumSectionContent.setId(id);
			curriculumSectionContent.setDisplayOrder(displayOrder);
			curriculumSectionContentService.doUpdateCurriculumSectionContentDisplayOrder(curriculumSectionContent);
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Section Content Display Order updated Successfully");
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
			CurriculumSectionContent curriculumSectionContent = new CurriculumSectionContent();
			curriculumSectionContent.setId(id);
			curriculumSectionContentService.doDeleteCurriculumSectionContent(curriculumSectionContent);
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Section Content Deleted Successfully");
			response.setData("");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
