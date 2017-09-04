package com.revature.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.exception.DataAccessException;
import com.revature.models.Curriculum;

@Repository
public class CurriculamDAO {

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
}
