package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.models.Module;

public interface ModuleDAO {
	List<Module> getAllModules() throws DataServiceException;

	void addModule(Module module) throws DataServiceException;
}
