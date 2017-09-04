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
 * The persistent class for the curriculum_act_req_artifacts database table.
 * 
 */
@Entity
@Table(name = "curriculum_act_req_artifacts")
public class CurriculumActivityRequireArtifact implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "type")
  private String type;

  @Column(name = "allowed_file_types")
  private String allowedFileTypes;

  @Column(name = "no_of_submission_allowed")
  private Integer noOfSubmissionAllowed;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "curriculum_act_id")
  private CurriculumActivity curriculumActivity;

  // ----------------------------- Constructor
  public CurriculumActivityRequireArtifact() {
    // No arg cons
  }

  // ----------------------------------- Getter Setter

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAllowedFileTypes() {
    return allowedFileTypes;
  }

  public void setAllowedFileTypes(String allowedFileTypes) {
    this.allowedFileTypes = allowedFileTypes;
  }

  public Integer getNoOfSubmissionAllowed() {
    return noOfSubmissionAllowed;
  }

  public void setNoOfSubmissionAllowed(Integer noOfSubmissionAllowed) {
    this.noOfSubmissionAllowed = noOfSubmissionAllowed;
  }

  public CurriculumActivity getCurriculumActivity() {
    return curriculumActivity;
  }

  public void setCurriculumActivity(CurriculumActivity curriculumActivity) {
    this.curriculumActivity = curriculumActivity;
  }

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here [AVINASH]
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof CurriculumActivityRequireArtifact))
      return false;

    CurriculumActivityRequireArtifact that = (CurriculumActivityRequireArtifact) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
