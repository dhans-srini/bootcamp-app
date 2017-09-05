package com.revature.controller;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.ModuleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.Module;
import com.revature.vo.HttpStatusResponse;
@RestController
public class ModuleController {
	private static Logger logger = Logger.getLogger(ModuleController.class);
	@Autowired
	ModuleService moduleService;

	@RequestMapping(value = "/modules", method = RequestMethod.GET)
	public ResponseEntity<HttpStatusResponse> getAllModules() {
		List<Module> modules = null;
		HttpStatusResponse response = new HttpStatusResponse();
		try {
			modules = moduleService.doGetAllModules();
			response.setData(modules);
			response.setDescription("Modules retrieved successfully");
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
