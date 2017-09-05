package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.revature.vo.HttpStatusResponse;

@RestController
@RequestMapping("/curriculum/section")
public class CurriculumSectionController {
	@Autowired
	public CurriculumSectionService curriculumSectionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<HttpStatusResponse> getAllCurriculumSections() {
		HttpStatusResponse response = new HttpStatusResponse();
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			curriculumSections = curriculumSectionService.doGetAllCurriculumSections();
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Sections Retrieved Successfully");
			response.setData(curriculumSections);
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<HttpStatusResponse> getCurriculumSectionById(@PathVariable("id") Long id) {
		HttpStatusResponse response = new HttpStatusResponse();
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			curriculumSections = curriculumSectionService.doGetCurriculumSectionByCurriculumId(id);
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Sections Retrieved Successfully");
			response.setData(curriculumSections);
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<HttpStatusResponse> saveCurriculumSection(@RequestBody CurriculumSection curriculumSection) {
		HttpStatusResponse response = new HttpStatusResponse();
		try {
			curriculumSectionService.doSaveCurriculumSection(curriculumSection);
			response.setStatusCode(HttpStatus.OK.value());
			response.setDescription("Curriculum Section Saved Successfully");
			response.setData("");
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
