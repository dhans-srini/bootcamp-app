package com.revature.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CurriculumDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.QueryParameter;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.models.Curriculum;
import com.revature.vo.CurriculumVO;

@Repository
public class CurriculumDAOImpl implements CurriculumDAO {
  private static final String DATA_RETRIEVAL_FAILED = "Data Retrieval Failed";
  
  private static Logger log = Logger.getLogger(CurriculumDAOImpl.class);

  @Autowired
  private DataRetriever dataRetriever;

  @Autowired
  private DataModifier dataModifier;

  public void saveCurriculam() {
    try {
      Curriculum c = new Curriculum();

      dataModifier.insert(c);
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<CurriculumVO> getCurriculums() throws DataServiceException {
    List<CurriculumVO> curriculums = null;
    try {
      StringBuilder queryString = new StringBuilder();
      queryString.append("select CAST(c.id as UNSIGNED ) curriculumId,c.title title,c.descriptions description, concat(c.mode) mode, ")
          .append("c.unique_key uniqueName,concat(e.FIRST_NAME, e.last_name) createdBy, ")
          .append("c.created_on createdOn from curriculums c  ")
          .append("join employees e on e.id=c.created_by");
      curriculums = dataRetriever.retrieveBySQLResultTransformer(queryString.toString(), CurriculumVO.class);
     
    } catch (DataAccessException dataAccessException) {
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue(DATA_RETRIEVAL_FAILED), dataAccessException);
    }
    return curriculums;
  }

  @Override
  public void updateCurriculumStatus(Long curriculumId, boolean status) throws DataServiceException {
    try {
      List<QueryParameter<?>> queryParam = new ArrayList<>();
      queryParam.add(new QueryParameter<>("status", status));
      queryParam.add(new QueryParameter<>("id", curriculumId));
      dataModifier.executeQuery("Update Curriculum Set isActive=:status Where id=:id", queryParam);
    } catch (DataAccessException e) {
      log.error(e.getMessage(), e);
    }
    
  }
}
