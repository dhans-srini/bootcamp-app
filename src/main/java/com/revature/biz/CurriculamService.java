package com.revature.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.CurriculamDAO;

@Service
public class CurriculamService {
  @Autowired
  private CurriculamDAO curriculamDAO;

  public void saveCurriculam() {
    curriculamDAO.saveCurriculam();
  }

}
