package com.revature.vo;

import java.math.BigInteger;

public class CurriculumSectionVO {
	private BigInteger id;
	private String title;
	private Integer displayOrder;
	private BigInteger curriculumId;
	private String curriculumTitle;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public BigInteger getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(BigInteger curriculumId) {
		this.curriculumId = curriculumId;
	}

	public String getCurriculumTitle() {
		return curriculumTitle;
	}

	public void setCurriculumTitle(String curriculumTitle) {
		this.curriculumTitle = curriculumTitle;
	}
}
