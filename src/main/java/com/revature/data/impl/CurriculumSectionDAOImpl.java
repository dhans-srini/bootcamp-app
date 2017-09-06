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
import com.revature.vo.CurriculumSectionVO;

@Repository
public class CurriculumSectionDAOImpl implements CurriculumSectionDAO {
	@Autowired
	private DataRetriever dataRetriever;

	@Autowired
	private DataModifier dataModifier;
	private static final Logger LOG = Logger.getLogger(CurriculumSectionDAOImpl.class);

	@Override
	public List<CurriculumSectionVO> doGetAllCurriculumSections() throws DataServiceException {
		List<CurriculumSectionVO> curriculumSectionVOs = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"SELECT cs.id id,cs.title title,cs.display_order displayOrder,c.id curriculumId,c.title curriculumTitle FROM curriculum_sections cs join curriculums c ON cs.curriculum_id = c.id ");
			LOG.debug("Preparing query for execution");
			curriculumSectionVOs = dataRetriever.retrieveBySQLResultTransformer(query.toString(),
					CurriculumSectionVO.class);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionVOs;
	}

	@Override
	public List<CurriculumSectionVO> doGetCurriculumSectionById(Long id) throws DataServiceException {
		List<CurriculumSectionVO> curriculumSectionVOs = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"SELECT cs.id as id,cs.title as title,cs.display_order as displayOrder,c.id as curriculumId,c.title as curriculumTitle FROM curriculum_sections cs join curriculums c ON cs.curriculum_id = c.id ");
			query.append(" where cs.id=:id");
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("id", id));
			curriculumSectionVOs = dataRetriever.retrieveBySQLResultTransformer(query.toString(), queryParam,
					CurriculumSectionVO.class);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionVOs;
	}

	@Override
	public List<CurriculumSectionVO> doGetCurriculumSectionByCurriculumId(Long curriculumId) throws DataServiceException {
		List<CurriculumSectionVO> curriculumSectionVOs = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"SELECT cs.id as id,cs.title as title,cs.display_order as displayOrder,c.id as curriculumId,c.title as curriculumTitle FROM curriculum_sections cs join curriculums c ON cs.curriculum_id = c.id ");
			query.append(" where c.id=:curriculumId");
			LOG.debug("Preparing query for execution");
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("curriculumId", curriculumId));
			curriculumSectionVOs = dataRetriever.retrieveBySQLResultTransformer(query.toString(), queryParam,
					CurriculumSectionVO.class);
			LOG.debug("Query execution success");
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return curriculumSectionVOs;
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
	public void doUpdateCurriculumSectionDisplayOrder(CurriculumSection curriculumSection) throws DataServiceException {
		try {
			String query = "UPDATE curriculum_sections cs SET cs.display_order=:displayOrder WHERE cs.id=:id";
			List<QueryParameter<?>> queryParam = new ArrayList<>();
			queryParam.add(new QueryParameter<>("id", curriculumSection.getId()));
			queryParam.add(new QueryParameter<>("displayOrder", curriculumSection.getDisplayOrder()));
			dataModifier.executeSQLQuery(query, queryParam);
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
