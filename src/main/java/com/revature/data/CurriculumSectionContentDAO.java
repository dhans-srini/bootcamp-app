package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSectionContent;

public interface CurriculumSectionContentDAO {
  /**
   * Get all Curriculum Section Contents
   * 
   * @return List of Curriculum Section Contents
   * @throws DataServiceException
   */
  List<CurriculumSectionContent> doGetAllCurriculumSectionContent() throws DataServiceException;

  /**
   * Get all Curriculum Section Contents based on id
   * 
   * @param id
   * @return List of Curriculum Section Contents
   * @throws DataServiceException
   */
  List<CurriculumSectionContent> doGetCurriculumSectionContentById(Long id)
      throws DataServiceException;

  /**
   * Save new Curriculum Section Content
   * 
   * @param curriculumSectionContent
   * @throws DataServiceException
   */
  void doSaveCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws DataServiceException;

  /**
   * Update Curriculum Section Content
   * 
   * @param curriculumSectionContent
   * @throws DataServiceException
   */
  void doUpdateCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws DataServiceException;

  /**
   * Update Curriculum Section Content Display Order
   * 
   * @param curriculumSectionContent
   * @throws DataServiceException
   */
  void doUpdateCurriculumSectionContentDisplayOrder(
      CurriculumSectionContent curriculumSectionContent) throws DataServiceException;

  /**
   * Delete Curriculum Section Content
   * 
   * @param curriculumSectionContent
   * @throws DataServiceException
   */
  void doDeleteCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
      throws DataServiceException;

  /**
   * Get all curriculum section Contents by parent Activity Id
   * 
   * @param parentCurriculumActivityId
   * @return
   * @throws DataServiceException
   */
  List<CurriculumSectionContent> doGetCurriculumSectionContentByParentActivityId(
      Long parentCurriculumActivityId) throws DataServiceException;

  /**
   * Get all curriculum section Contents by Section Id
   * 
   * @param curriculumSectionId
   * @return
   * @throws DataServiceException
   */
  List<CurriculumSectionContent> doGetCurriculumSectionContentByCurriculumSectionId(
      Long curriculumSectionId) throws DataServiceException;

  /**
   * Get all curriculum section Contents by module Id
   * 
   * @param moduleId
   * @return
   * @throws DataServiceException
   */
  List<CurriculumSectionContent> doGetCurriculumSectionContentByModuleId(Long moduleId)
      throws DataServiceException;

  /**
   * Get all curriculum section Contents by curriculum Activity Id
   * 
   * @param curriculumActivityId
   * @return
   * @throws DataServiceException
   */
  List<CurriculumSectionContent> doGetCurriculumSectionContentByCurriculumActivityId(
      Long curriculumActivityId) throws DataServiceException;

}
