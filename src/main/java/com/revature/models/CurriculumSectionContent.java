package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the curriculum_section_contents database table.
 * 
 */
@Entity
@Table(name = "curriculum_section_contents")
public class CurriculumSectionContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curriculum_sec_id")
	private CurriculumSection curriculumSection;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	private Module module;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curriculum_act_id")
	private CurriculumActivity curriculumActivity;

	@Column(name = "parent_curriculum_act_id")
	private Long parentCurriculumActivityId;

	@Column(name = "display_order")
	private Integer displayOrder;

	// ----------------------------- Constructor
	public CurriculumSectionContent() {
		// No arg cons
	}

	// ----------------------------------- Getter Setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CurriculumSection getCurriculumSection() {
		return curriculumSection;
	}

	public void setCurriculumSection(CurriculumSection curriculumSection) {
		this.curriculumSection = curriculumSection;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public CurriculumActivity getCurriculumActivity() {
		return curriculumActivity;
	}

	public void setCurriculumActivity(CurriculumActivity curriculumActivity) {
		this.curriculumActivity = curriculumActivity;
	}

	public Long getParentCurriculumActivityId() {
		return parentCurriculumActivityId;
	}

	public void setParentCurriculumActivityId(Long parentCurriculumActivityId) {
		this.parentCurriculumActivityId = parentCurriculumActivityId;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public int hashCode() {
		return id != null ? id.intValue() : super.hashCode();
	}

	// ------------------- equals customized here [AVINASH]
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CurriculumSectionContent))
			return false;

		CurriculumSectionContent that = (CurriculumSectionContent) obj;
		return this.id == null ? false : this.id.equals(that.getId());
	}
}
