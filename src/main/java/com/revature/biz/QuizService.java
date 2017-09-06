package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.vo.QuizVO;

/**
 * Created on 05/09/2017
 */
public interface QuizService {
  /**
   * To get active quizzes.
   * 
   * @return {@link List}
   * @throws BusinessServiceException
   */
  List<QuizVO> doGetQuizzes() throws BusinessServiceException;

}
