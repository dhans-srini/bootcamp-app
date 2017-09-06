package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.vo.CurriculumVO;

public interface CurriculumService {
  
  public void saveCurriculam();

  public List<CurriculumVO> doGetAllCurriculums() throws BusinessServiceException;

  public void doUpdateCurriculumStatus(Long curriculumId, boolean status) throws BusinessServiceException;
}
