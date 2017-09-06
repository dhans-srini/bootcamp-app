package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSection;
import com.revature.vo.CurriculumSectionVO;

/**
 * This method contains Curriculum Section related DAO's
 * 
 * @author Admin
 *
 */
public interface CurriculumSectionDAO {
  /**
   * Get all Curriculum Sections
   * 
   * @return List of CurriculumSectionVO
   * @throws DataServiceException
   */
  List<CurriculumSectionVO> doGetAllCurriculumSections() throws DataServiceException;

  /**
   * Insert new Curriculum Section
   * 
   * @param curriculumSection
   * @throws DataServiceException
   */
  void doSaveCurriculumSection(CurriculumSection curriculumSection) throws DataServiceException;

  /**
   * Update Curriculum Section
   * 
   * @param curriculumSection
   * @throws DataServiceException
   */
  void doUpdateCurriculumSection(CurriculumSection curriculumSection) throws DataServiceException;

  /**
   * Delete Curriculum Section
   * 
   * @param curriculumSection
   * @throws DataServiceException
   */
  void doDeleteCurriculumSection(CurriculumSection curriculumSection) throws DataServiceException;

  /**
   * Get all Curriculum Sections By Id
   * 
   * @param id
   * @return List of CurriculumSectionVO
   * @throws DataServiceException
   */
  List<CurriculumSectionVO> doGetCurriculumSectionById(Long id) throws DataServiceException;

  /**
   * Get all Curriculum Sections By Curriculum Id
   * 
   * @param curriculumId
   * @return List of CurriculumSectionVO
   * @throws DataServiceException
   */
  List<CurriculumSectionVO> doGetCurriculumSectionByCurriculumId(Long curriculumId)
      throws DataServiceException;

  /**
   * Updates display order of the Curriculum Section based on id
   * 
   * @param curriculumSection
   * @throws DataServiceException
   */
  void doUpdateCurriculumSectionDisplayOrder(CurriculumSection curriculumSection)
      throws DataServiceException;

}
