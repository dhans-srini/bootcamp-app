package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.vo.CurriculumVO;

public interface CurriculumDAO {
  
  void saveCurriculam();

  List<CurriculumVO> getCurriculums() throws DataServiceException;

  void updateCurriculumStatus(Long curriculumId,boolean status)throws DataServiceException;

}
