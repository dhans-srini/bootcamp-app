package com.revature.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CurriculumSectionDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.QueryParameter;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.access.exception.DuplicateRecordException;
import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSection;

@Repository
public class CurriculumSectionDAOImpl implements CurriculumSectionDAO {
	@Autowired
	private DataRetriever dataRetriever;

	@Autowired
	private DataModifier dataModifier;
	private static final Logger LOG = Logger.getLogger(CurriculumSectionDAOImpl.class);

	@Override
	public List<CurriculumSection> doGetAllCurriculumSections() throws DataServiceException {
		List<CurriculumSection> curriculumSections = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			curriculumSections = dataRetriever.retrieveByHQL("from CurriculumSection ");
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSections;
	}

	@Override
	public List<CurriculumSection> doGetCurriculumSectionById(Long id) throws DataServiceException {
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("id", id));
			curriculumSections = dataRetriever.retrieveByHQL("from CurriculumSection where id=:id", queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSections;
	}

	@Override
	public List<CurriculumSection> doGetCurriculumSectionByCurriculumId(Long curriculumId) throws DataServiceException {
		List<CurriculumSection> curriculumSections = new ArrayList<CurriculumSection>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("curriculumId", curriculumId));
			curriculumSections = dataRetriever.retrieveByHQL(
					"from CurriculumSection cs join fetch cs.curriculum c where c.id=:curriculumId", queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSections;
	}

	@Override
	public void doSaveCurriculumSection(CurriculumSection curriculumSection) throws DataServiceException {
		try {
			dataModifier.insert(curriculumSection);
			LOG.debug("Curriculum Section saved successfully");
		} catch (DuplicateRecordException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void doUpdateCurriculumSection(CurriculumSection curriculumSection) throws DataServiceException {
		try {
			dataModifier.update(curriculumSection);
			LOG.debug("Curriculum Section updated successfully");
		} catch (DuplicateRecordException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void doDeleteCurriculumSection(CurriculumSection curriculumSection) throws DataServiceException {
		try {
			dataModifier.delete(curriculumSection);
			LOG.debug("Curriculum Section deleted successfully");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}
}
