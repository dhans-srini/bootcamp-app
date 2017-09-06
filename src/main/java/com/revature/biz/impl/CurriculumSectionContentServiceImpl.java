package com.revature.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CurriculumSectionContentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CurriculumSectionContentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSectionContent;

@Service
public class CurriculumSectionContentServiceImpl implements CurriculumSectionContentService {
  @Autowired
  public CurriculumSectionContentDAO curriculumSectionContentDAO;

  @Override
  public List<CurriculumSectionContent> doGetAllCurriculumSectionContents()
      throws BusinessServiceException {
    List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
    try {
      curriculumSectionContents = curriculumSectionContentDAO.doGetAllCurriculumSectionContent();
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
    return curriculumSectionContents;
  }

  @Override
  public List<CurriculumSectionContent> doGetCurriculumSectionContentById(Long id)
      throws BusinessServiceException {
    List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
    try {
      curriculumSectionContents = curriculumSectionContentDAO.doGetCurriculumSectionContentById(id);
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
    return curriculumSectionContents;
  }

  @Override
  public void doSaveCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws BusinessServiceException {
    try {
      curriculumSectionContentDAO.doSaveCurriculumSectionContent(curriculumSectionContent);
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void doUpdateCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws BusinessServiceException {
    try {
      curriculumSectionContentDAO.doUpdateCurriculumSectionContent(curriculumSectionContent);
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void doUpdateCurriculumSectionContentDisplayOrder(
      CurriculumSectionContent curriculumSectionContent) throws BusinessServiceException {
    try {
      curriculumSectionContentDAO
          .doUpdateCurriculumSectionContentDisplayOrder(curriculumSectionContent);
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
  }

  @Override
  public void doDeleteCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws BusinessServiceException {
    try {
      curriculumSectionContentDAO.doDeleteCurriculumSectionContent(curriculumSectionContent);
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
  }
}
