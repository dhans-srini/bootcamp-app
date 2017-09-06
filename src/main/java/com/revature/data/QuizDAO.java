package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.vo.QuizVO;

public interface QuizDAO {
  /**
   * To get active quizzes.
   * 
   * @return {@link List}
   * @throws DataServiceException
   */
  List<QuizVO> getQuizzes() throws DataServiceException;

}
