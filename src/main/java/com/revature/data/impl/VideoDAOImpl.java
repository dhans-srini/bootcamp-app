package com.revature.data.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.VideoDAO;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.vo.QuizVO;
import com.revature.vo.VideoVO;

@Repository
public class VideoDAOImpl implements VideoDAO, Serializable {
  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(VideoDAOImpl.class);
  private static final String DATA_RETRIVAL_FAILED = "Data retrival failed";

  @Autowired
  private DataRetriever dataRetriever;

  @Override
  public List<VideoVO> getVideos() throws DataServiceException {
    try {
      logger.debug("Preparing query for getting active videos");
      StringBuilder queryString = new StringBuilder();
      queryString.append("SELECT v.id,v.`NAME` as title FROM `videos` v JOIN `categories` c"
          + " ON c.`ID` = v.`CAT_ID` WHERE v.`IS_ACTIVE` = TRUE AND c.`IS_ACTIVE` = TRUE"
          + " ORDER BY v.`CREATED_ON` DESC");

      logger.debug("Retrieve active videos successfully");
      return dataRetriever.retrieveBySQLResultTransformer(queryString.toString(), QuizVO.class);
    } catch (DataAccessException dataAccessException) {
      logger.error("Active videos retrieval failed.", dataAccessException);
      throw new DataServiceException(
          DataUtils.getInstance().getPropertyFileValue(DATA_RETRIVAL_FAILED), dataAccessException);
    }
  }
}
