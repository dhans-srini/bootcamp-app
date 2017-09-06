package com.revature.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CurriculumSectionContentDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;
import com.revature.data.access.QueryParameter;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.access.exception.DuplicateRecordException;
import com.revature.data.exception.DataServiceException;
import com.revature.models.CurriculumSectionContent;

@Repository
public class CurriculumSectionContentDAOImpl implements CurriculumSectionContentDAO {
	@Autowired
	private DataRetriever dataRetriever;

	@Autowired
	private DataModifier dataModifier;
	private static final Logger LOG = Logger.getLogger(CurriculumSectionContentDAOImpl.class);

	@Override
	public List<CurriculumSectionContent> doGetAllCurriculumSectionContent() throws DataServiceException {
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			curriculumSectionContents = dataRetriever.retrieveByHQL("from CurriculumSectionContent");
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionContents;
	}

	@Override
	public List<CurriculumSectionContent> doGetCurriculumSectionContentById(Long id) throws DataServiceException {
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("id", id));
			curriculumSectionContents = dataRetriever.retrieveByHQL("from CurriculumSectionContent where id=:id",
					queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionContents;
	}

	@Override
	public List<CurriculumSectionContent> doGetCurriculumSectionContentByCurriculumSectionId(Long curriculumSectionId)
			throws DataServiceException {
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("curriculumSectionId", curriculumSectionId));
			curriculumSectionContents = dataRetriever.retrieveByHQL(
					"from CurriculumSectionContent csc join fetch csc.curriculumSection cs where cs.id=:curriculumSectionId",
					queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionContents;
	}

	@Override
	public List<CurriculumSectionContent> doGetCurriculumSectionContentByModuleId(Long moduleId)
			throws DataServiceException {
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("moduleId", moduleId));
			curriculumSectionContents = dataRetriever.retrieveByHQL(
					"from CurriculumSectionContent csc join fetch csc.module m where m.id=:moduleId", queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionContents;
	}

	@Override
	public List<CurriculumSectionContent> doGetCurriculumSectionContentByCurriculumActivityId(Long curriculumActivityId)
			throws DataServiceException {
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("curriculumActivityId", curriculumActivityId));
			curriculumSectionContents = dataRetriever.retrieveByHQL(
					"from CurriculumSectionContent csc join fetch csc.curriculumActivity ca where ca.id=:curriculumActivityId",
					queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionContents;
	}

	@Override
	public List<CurriculumSectionContent> doGetCurriculumSectionContentByParentActivityId(
			Long parentCurriculumActivityId) throws DataServiceException {
		List<CurriculumSectionContent> curriculumSectionContents = new ArrayList<>();
		try {
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("parentCurriculumActivityId", parentCurriculumActivityId));
			curriculumSectionContents = dataRetriever.retrieveByHQL(
					"from CurriculumSectionContent csc where csc.parentCurriculumActivityId=:parentCurriculumActivityId",
					queryParam);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionContents;
	}

	@Override
	public void doSaveCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
			throws DataServiceException {
		try {
			dataModifier.insert(curriculumSectionContent);
			LOG.debug("Curriculum Section Content saved successfully");
		} catch (DuplicateRecordException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void doUpdateCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
			throws DataServiceException {
		try {
			dataModifier.update(curriculumSectionContent);
			LOG.debug("Curriculum Section Content updated successfully");
		} catch (DuplicateRecordException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void doUpdateCurriculumSectionContentDisplayOrder(CurriculumSectionContent curriculumSectionContent)
			throws DataServiceException {
		try {
			String query = "UPDATE curriculum_section_contents csc SET csc.display_order=:displayOrder WHERE csc.id=:id";
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("id", curriculumSectionContent.getId()));
			queryParam.add(new QueryParameter<>("displayOrder", curriculumSectionContent.getDisplayOrder()));
			dataModifier.executeSQLQuery(query, queryParam);
			LOG.debug("Curriculum Section Content updated successfully");
		} catch (DuplicateRecordException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void doDeleteCurriculumSectionContent(CurriculumSectionContent curriculumSectionContent)
			throws DataServiceException {
		try {
			dataModifier.delete(curriculumSectionContent);
			LOG.debug("Curriculum Section Content deleted successfully");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
	}
}
