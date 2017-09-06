package com.revature.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.QuizDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.vo.QuizVO;

@Service
public class QuizServiceImpl implements QuizService {
  @Autowired
  private QuizDAO quizDAO;

  @Override
  public List<QuizVO> doGetQuizzes() throws BusinessServiceException {
    try {
      return quizDAO.getQuizzes();
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
  }
}
