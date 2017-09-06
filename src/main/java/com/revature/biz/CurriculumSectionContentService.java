package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.CurriculumSectionContent;

public interface CurriculumSectionContentService {
  /**
   * Get all Curriculum Section Contents
   * 
   * @return
   * @throws BusinessServiceException
   */
  List<CurriculumSectionContent> doGetAllCurriculumSectionContents()
      throws BusinessServiceException;

  /**
   * Get all Curriculum Section contents by id
   * 
   * @param id
   * @return
   * @throws BusinessServiceException
   */
  List<CurriculumSectionContent> doGetCurriculumSectionContentById(Long id)
      throws BusinessServiceException;

  /**
   * Save new Curriculum Section Content
   * 
   * @param curriculumSectionContent
   * @throws BusinessServiceException
   */
  void doSaveCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws BusinessServiceException;

  /**
   * Update Curriculum Section Content
   * 
   * @param curriculumSectionContent
   * @throws BusinessServiceException
   */
  void doUpdateCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws BusinessServiceException;

  /**
   * Update Curriculum Section Content Display Order
   * 
   * @param curriculumSectionContent
   * @throws BusinessServiceException
   */
  void doUpdateCurriculumSectionContentDisplayOrder(
      CurriculumSectionContent curriculumSectionContent) throws BusinessServiceException;

  /**
   * Delete Curriculum Section Content
   * 
   * @param curriculumSectionContent
   * @throws BusinessServiceException
   */
  void doDeleteCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws BusinessServiceException;
}
