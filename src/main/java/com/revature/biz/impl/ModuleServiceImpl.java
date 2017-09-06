package com.revature.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.ModuleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.ModuleDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.models.Module;

@Service
public class ModuleServiceImpl implements ModuleService {

	private static Logger logger = Logger.getLogger(ModuleServiceImpl.class);

	@Autowired
	private ModuleDAO moduleDAO;

	@Override
	public List<Module> doGetAllModules() throws BusinessServiceException {
		List<Module> modules = new ArrayList<>();
		try {
			logger.info("Listing the all modules");
			modules = moduleDAO.getAllModules();
			logger.debug("Modules are retrieved successfully");
		} catch (DataServiceException e) {
			logger.error("Failed to list the modules");
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return modules;
	}

	@Override
	public void doAddModule(Module module) throws BusinessServiceException {
		try {
			logger.info("Adding the module");
			moduleDAO.addModule(module);
			logger.debug("Module added successfully");
		} catch (DataServiceException e) {
			logger.error("Failed to add the module");
			throw new BusinessServiceException(e.getMessage(), e);
		}

	}

	

	@Override
	public void doDeleteModule(Module module) throws BusinessServiceException {
		try {
			logger.info("Deleting the module");
			moduleDAO.deleteModule(module);
			logger.debug("Module deleted successfully");
		} catch (DataServiceException e) {
			logger.error("Failed to delete the module");
			throw new BusinessServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void doUpdateModuleStatus(Long moduleId, Boolean isActive) throws BusinessServiceException {
		try {
			logger.info("Updating the module status");
			moduleDAO.updateModuleStatus(moduleId, isActive);
			logger.debug("Module status updated successfully");
		} catch (DataServiceException e) {
			logger.error("Failed to update the module status");
			throw new BusinessServiceException(e.getMessage(), e);
		}
		
	}

}
