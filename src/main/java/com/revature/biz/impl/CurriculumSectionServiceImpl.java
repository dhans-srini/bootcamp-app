package com.revature.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CurriculumSectionService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CurriculumSectionDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSection;

@Service
public class CurriculumSectionServiceImpl implements CurriculumSectionService {
	@Autowired
	public CurriculumSectionDAO curriculumSectionDAO;

	@Override
	public List<CurriculumSection> doGetAllCurriculumSections() throws BusinessServiceException {
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			curriculumSections = curriculumSectionDAO.doGetAllCurriculumSections();
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return curriculumSections;
	}

	@Override
	public List<CurriculumSection> doGetCurriculumSectionById(Long id) throws BusinessServiceException {
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			curriculumSections = curriculumSectionDAO.doGetCurriculumSectionById(id);
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return curriculumSections;
	}

	@Override
	public List<CurriculumSection> doGetCurriculumSectionByCurriculumId(Long curriculumId)
			throws BusinessServiceException {
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			curriculumSections = curriculumSectionDAO.doGetCurriculumSectionByCurriculumId(curriculumId);
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return curriculumSections;
	}

	@Override
	public void doSaveCurriculumSection(CurriculumSection curriculumSection) throws BusinessServiceException {
		try {
			curriculumSectionDAO.doSaveCurriculumSection(curriculumSection);
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void doUpdateCurriculumSection(CurriculumSection curriculumSection) throws BusinessServiceException {
		try {
			curriculumSectionDAO.doUpdateCurriculumSection(curriculumSection);
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public void doDeleteCurriculumSection(CurriculumSection curriculumSection) throws BusinessServiceException {
		try {
			curriculumSectionDAO.doDeleteCurriculumSection(curriculumSection);
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
	}
}
