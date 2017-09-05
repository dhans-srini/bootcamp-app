package com.revature.data.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CurriculumSectionContentDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriever;

@Repository
public class CurriculumSectionContentDAOImpl implements CurriculumSectionContentDAO {
	@Autowired
	private DataRetriever dataRetriever;

	@Autowired
	private DataModifier dataModifier;
	private static final Logger LOG = Logger.getLogger(CurriculumSectionContentDAOImpl.class);
}
