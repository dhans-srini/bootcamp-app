package com.revature.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.ModuleDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.models.Module;
import com.revature.data.utils.DataUtils;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.exception.DataAccessException;

/**
 * This class is used to perform the data layer implementation for module
 * management.
 *
 *
 */
@Repository
public class ModuleDAOImpl implements ModuleDAO {
	@Autowired
	private DataRetriever dataRetriever;

	@Autowired
	private DataModifier dataModifier;

	private static final Logger logger = Logger.getLogger(ModuleDAOImpl.class);

	/**
	 * This method is for getting all modules list.
	 */
	@Override
	public List<Module> getAllModules() throws DataServiceException {
		List<Module> modules = new ArrayList<Module>();

		try {
			logger.info("Retrieving all modules");
			modules = dataRetriever.retrieveBySQL("select * from modules");
			logger.debug("Modules retrieved successfully");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getInstance().getPropertyFileValue("msg.data.retrieval.fail"), e);
		}

		return modules;
	}

	@Override
	public void addModule(Module module) throws DataServiceException {
	try{
		logger.info("Adding new module");
		dataModifier.insert(module);
		logger.debug("Module added successfully");
	}
	catch (DataAccessException e) {
		logger.error("Module addition failed", e);
		throw new DataServiceException(DataUtils.getInstance().getPropertyFileValue("msg.data.insert.fail"), e);
	}
		
	}

}
