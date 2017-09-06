package com.revature.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CurriculumService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CurriculamDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.vo.CurriculumVO;

@Service
public class CurriculumServiceImpl implements CurriculumService {
  
  private static Logger log = Logger.getLogger(CurriculumServiceImpl.class);
  
  @Autowired
  private CurriculamDAO curriculamDAO;

  public void saveCurriculam() {
    curriculamDAO.saveCurriculam();
  }

  @Override
  public List<CurriculumVO> doGetAllCurriculums() throws BusinessServiceException {
   List<CurriculumVO> curriculums= new ArrayList<>() ;
   
   try {
    curriculums = curriculamDAO.getCurriculums();
  } catch (DataServiceException e) {
    log.error(e.getMessage(), e);
  }
    return curriculums;
  }


  @Override
  public void doUpdateCurriculumStatus(Long curriculumId, boolean status)
      throws BusinessServiceException {
    try {
      curriculamDAO.updateCurriculumStatus(curriculumId,status);
    } catch (DataServiceException e) {
      log.error(e.getMessage(), e);
    }
    
  }

}
