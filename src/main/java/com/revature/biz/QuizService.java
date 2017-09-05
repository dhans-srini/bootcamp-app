package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.vo.QuizVO;

public interface QuizService {
  /**
   * To get active quizzes.
   * 
   * @return {@link List}
   * @throws BusinessServiceException
   */
  List<QuizVO> doGetQuizzes() throws BusinessServiceException;;

}
