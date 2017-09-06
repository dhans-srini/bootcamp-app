package com.revature.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

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

import com.revature.biz.ModuleService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.Employee;
import com.revature.models.Module;
import com.revature.models.Organization;
import com.revature.utils.ServiceConstants;
import com.revature.utils.ServiceResponseUtils;
import com.revature.vo.HttpStatusResponse;
import com.revature.vo.ModuleVO;
import com.revature.vo.ServiceResponse;

@RestController
public class ModuleController {
  private static Logger logger = Logger.getLogger(ModuleController.class);
  @Autowired
  ModuleService moduleService;

  @RequestMapping(value = "/modules", method = RequestMethod.GET)
  public ResponseEntity<HttpStatusResponse> getAllModules() {
    try {
      List<Module> modules = moduleService.doGetAllModules();
      if (CollectionUtils.isNotEmpty(modules)) {
        return new ResponseEntity<>(ServiceResponseUtils.setHttpResponse(HttpStatus.OK.value(),
            "Data retrived successfully", modules), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(ServiceResponseUtils.setHttpResponse(
            HttpStatus.NO_CONTENT.value(), "No records founds", null), HttpStatus.NO_CONTENT);
      }
    } catch (BusinessServiceException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/module", method = RequestMethod.POST)
  public ServiceResponse saveModule(@RequestBody ModuleVO moduleVO, HttpServletRequest request) {
    ServiceResponse serviceResponse;
    try {
      Module module = new Module();
      module.setTitle(moduleVO.getTitle());
      module.setTags(moduleVO.getTags());
      module.setUniqueKey(moduleVO.getUniqueKey());
      module.setDescription(moduleVO.getDescriptions());
      module.setShowDiscriptions(moduleVO.getShowDiscriptions());
      Organization org = new Organization();
      org.setId(moduleVO.getOrganizationId());
      module.setOrganization(org);
      Employee emp = new Employee();
      emp.setId(moduleVO.getEmpId());
      module.setCreatedBy(emp);
      module.setIsScheduled(moduleVO.getIsScheduled());
      module.setDuration(moduleVO.getDuration());
      module.setDurationUom(moduleVO.getDurationUom());
      module.setIsHidden(moduleVO.getIsHidden());
      module.setIsActive(moduleVO.getIsActive());
      module.setParentModuleId(moduleVO.getParentModuleId());
      module.setCreatedOn(moduleVO.getCreatedOn());

      moduleService.doAddModule(module);

      if (Objects.nonNull(module)) {
        serviceResponse = ServiceResponseUtils.dataResponse(
            ServiceConstants.DATA_INSERTION_SUCCESS_CODE, "Module saved successfully", module);
      } else {
        serviceResponse = ServiceResponseUtils
            .dataResponse(ServiceConstants.DATA_INSERTION_FAILED_CODE, "Save Module failed", null);
      }
      return serviceResponse;
    } catch (BusinessServiceException be) {
      logger.error(be.getMessage(), be);
      serviceResponse = ServiceResponseUtils
          .dataResponse(ServiceConstants.DATA_INSERTION_FAILED_CODE, be.getMessage(), null);
      return serviceResponse;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      serviceResponse = ServiceResponseUtils.dataResponse(ServiceConstants.SYSTEM_ERROR_CODE,
          ServiceConstants.SYSTEM_ERROR_MESSAGE, null);
      return serviceResponse;
    }
  }



  @RequestMapping(value = "/module/{moduleId}", method = RequestMethod.DELETE)
  public ServiceResponse deleteModule(@PathVariable("moduleId") Long moduleId,
      HttpServletRequest request) {
    ServiceResponse serviceResponse;
    try {
      Module module = new Module();
      module.setId(moduleId);
      moduleService.doDeleteModule(module);
      serviceResponse = ServiceResponseUtils.dataResponse(
          ServiceConstants.DATA_DELETION_SUCCESS_CODE, "Module deleted successfully", null);
      return serviceResponse;
    } catch (BusinessServiceException be) {
      logger.error(be.getMessage(), be);
      serviceResponse = ServiceResponseUtils
          .dataResponse(ServiceConstants.DATA_DELETION_FAILED_CODE, be.getMessage(), null);
      return serviceResponse;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      serviceResponse = ServiceResponseUtils.dataResponse(ServiceConstants.SYSTEM_ERROR_CODE,
          ServiceConstants.SYSTEM_ERROR_MESSAGE, null);
      return serviceResponse;
    } finally {
      serviceResponse = null;
    }
  }

  @RequestMapping(value = "/module/{moduleId}/{isActive}", method = RequestMethod.PUT)
  public ServiceResponse updateModuleStatus(@PathVariable("moduleId") Long moduleId,
      @PathVariable("isActive") Boolean isActive, HttpServletRequest request) {
    ServiceResponse serviceResponse;
    try {
      moduleService.doUpdateModuleStatus(moduleId, isActive);
      serviceResponse = ServiceResponseUtils.dataResponse(ServiceConstants.DATA_UPDATE_SUCCESS_CODE,
          "Module status updated successfully", null);
      return serviceResponse;
    } catch (BusinessServiceException be) {
      logger.error(be.getMessage(), be);
      serviceResponse = ServiceResponseUtils.dataResponse(ServiceConstants.DATA_UPDATE_FAILED_CODE,
          be.getMessage(), null);
      return serviceResponse;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      serviceResponse = ServiceResponseUtils.dataResponse(ServiceConstants.SYSTEM_ERROR_CODE,
          ServiceConstants.SYSTEM_ERROR_MESSAGE, null);
      return serviceResponse;
    } finally {
      serviceResponse = null;
    }
  }
}
