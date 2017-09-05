package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSection;

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
	 * @return List of CurriculumSection
	 * @throws DataServiceException
	 */
	List<CurriculumSection> doGetAllCurriculumSections() throws DataServiceException;

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
	 * @return List of CurriculumSection
	 * @throws DataServiceException
	 */
	List<CurriculumSection> doGetCurriculumSectionById(Long id) throws DataServiceException;

	/**
	 * Get all Curriculum Sections By Curriculum Id
	 * 
	 * @param curriculumId
	 * @return List of CurriculumSection
	 * @throws DataServiceException
	 */
	List<CurriculumSection> doGetCurriculumSectionByCurriculumId(Long curriculumId) throws DataServiceException;

}