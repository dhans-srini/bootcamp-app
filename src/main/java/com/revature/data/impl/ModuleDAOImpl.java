package com.revature.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.ModuleDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.QueryParameter;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.models.CurriculumModuleActivity;
import com.revature.models.Module;

/**
 * This class is used to perform the data layer implementation for module management.
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
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue("msg.data.retrieval.fail"), e);
    }

    return modules;
  }

  @Override
  public void addModule(Module module) throws DataServiceException {
    try {
      logger.info("Adding new module");
      dataModifier.insert(module);
      logger.debug(String.format("Module saved with id : %s and created by : %s", module.getId(),
          module.getCreatedBy().getFullName()));
      logger.info(String.format("Module saved successfully, with id : %s", module.getId()));
    } catch (DataAccessException e) {
      logger.error("Module addition failed", e);
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue("msg.data.insert.fail"), e);
    }

  }

  @Override
  public void deleteModule(Module module) throws DataServiceException {
    try {
      logger.info("Deleting module");
      dataModifier.delete(module);
      logger.debug("Module deleted successfully");
      CurriculumModuleActivity curModAct = new CurriculumModuleActivity();
      dataModifier.delete(curModAct);
      logger.debug("Module activity deleted successfully");
    } catch (DataAccessException e) {
      logger.error(String.format("Module id =%d has some dependency so it cannot be deleted",
          module.getId()), e);
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue("msg.data.curriculum.module.dependency"), e);
    } catch (Exception e) {
      logger.error(String.format("Module with id=%d deletion failed", module.getId()), e);
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue("msg.data.delete.fail"), e);
    }
  }

  @Override
  public void updateModuleStatus(Long moduleId, Boolean isActive) throws DataServiceException {
    try {
      logger.info("Updating Module status");
      List<QueryParameter<?>> queryParam = new ArrayList<>();
      queryParam.add(new QueryParameter<>("activeValue", isActive));
      queryParam.add(new QueryParameter<>("moduleId", moduleId));
      dataModifier.executeQuery("UPDATE Module SET isActive=:activeValue WHERE id=:moduleId",
          queryParam);
    } catch (DataAccessException e) {
      logger.error(String.format("Module with id : %d status updation failed.", moduleId), e);
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue("msg.data.update.fail"), e);
    }
  }

}
