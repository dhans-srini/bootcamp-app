package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.models.CurriculumSection;

/**
 * This method contains Curriculum Section related Services
 * 
 * @author Admin
 *
 */
public interface CurriculumSectionService {
  /**
   * Get all Curriculum Sections
   * 
   * @return List of CurriculumSection
   * @throws BusinessServiceException
   */
  List<CurriculumSection> doGetAllCurriculumSections() throws BusinessServiceException;

  /**
   * Get All Curriculum Sections by Id
   * 
   * @param id
   * @return List of CurriculumSection
   * @throws BusinessServiceException
   */
  List<CurriculumSection> doGetCurriculumSectionById(Long id) throws BusinessServiceException;

  /**
   * Get All Curriculum Section by Curriculum Id
   * 
   * @param curriculumId
   * @return List of CurriculumSection
   * @throws BusinessServiceException
   */
  List<CurriculumSection> doGetCurriculumSectionByCurriculumId(Long curriculumId)
      throws BusinessServiceException;

  /**
   * Insert new Curriculum Section
   * 
   * @param curriculumSection
   * @throws BusinessServiceException
   */
  void doSaveCurriculumSection(CurriculumSection curriculumSection) throws BusinessServiceException;

  /**
   * Insert new Curriculum Section
   * 
   * @param curriculumSection
   * @throws BusinessServiceException
   */
  void doUpdateCurriculumSection(CurriculumSection curriculumSection)
      throws BusinessServiceException;

  /**
   * Delete Curriculum Section
   * 
   * @param curriculumSection
   * @throws BusinessServiceException
   */
  void doDeleteCurriculumSection(CurriculumSection curriculumSection)
      throws BusinessServiceException;

  /**
   * Updates the curriculum section display order based on id
   * 
   * @param curriculumSection
   * @throws BusinessServiceException
   */
  void doUpdateCurriculumSectionDisplayOrder(CurriculumSection curriculumSection)
      throws BusinessServiceException;

}
