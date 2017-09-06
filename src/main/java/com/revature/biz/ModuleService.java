package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.Module;

public interface ModuleService {

  List<Module> doGetAllModules() throws BusinessServiceException;

  void doAddModule(Module module) throws BusinessServiceException;

  void doDeleteModule(Module module) throws BusinessServiceException;

  void doUpdateModuleStatus(Long moduleId, Boolean isActive) throws BusinessServiceException;
}
