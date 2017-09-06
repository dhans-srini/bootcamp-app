package com.revature.data.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.QuizDAO;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.vo.QuizVO;

@Repository
public class QuizDAOImpl implements QuizDAO, Serializable {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(QuizDAOImpl.class);
  private static final String DATA_RETRIVAL_FAILED = "Data retrival failed";

  @Autowired
  private DataRetriever dataRetriever;

  @Override
  public List<QuizVO> getQuizzes() throws DataServiceException {
    try {
      logger.debug("Preparing query for getting active quizzes");
      StringBuilder queryString = new StringBuilder();
      queryString.append("SELECT a.id,a.title FROM assessments a JOIN "
          + "`categories` c ON c.`ID`=a.`CATEGORY_ID` WHERE a.mode='P' "
          + "AND a.IS_ACTIVE =TRUE AND c.`IS_ACTIVE` = TRUE");

      queryString.append(" order by a.CREATED_ON desc");
      logger.debug("Retrieve active quizzes successfully");
      return dataRetriever.retrieveBySQLResultTransformer(queryString.toString(), QuizVO.class);
    } catch (DataAccessException dataAccessException) {
      logger.error("Active quizzes retrieval failed.", dataAccessException);
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue(DATA_RETRIVAL_FAILED), dataAccessException);
    }
  }
}
