package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CurriculamService;

@RestController
public class CurriculamController {

  @Autowired
  private CurriculamService curriculamService;



  @RequestMapping("/save")
  public String scheduleEmail() throws Exception {
    curriculamService.saveCurriculam();
    return "success";
  }
}
