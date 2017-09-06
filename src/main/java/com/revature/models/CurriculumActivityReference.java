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
 * The persistent class for the curriculum_act_refs database table.
 * 
 */
@Entity
@Table(name = "curriculum_act_refs")
public class CurriculumActivityReference implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "type")
  private String type;

  @Column(name = "uniq_name")
  private String uniqueName;

  @Column(name = "descriptions")
  private String description;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "ref_url")
  private String referenceUrl;

  @Column(name = "is_tutorial_link")
  private Boolean isTutorialLink = false;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "video_id")
  private Video video;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "curriculum_act_id")
  private CurriculumActivity curriculumActivity;

  // ----------------------------- Constructor
  public CurriculumActivityReference() {
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

  public String getUniqueName() {
    return uniqueName;
  }

  public void setUniqueName(String uniqueName) {
    this.uniqueName = uniqueName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Boolean getIsTutorialLink() {
    return isTutorialLink;
  }

  public void setIsTutorialLink(Boolean isTutorialLink) {
    this.isTutorialLink = isTutorialLink;
  }

  public CurriculumActivity getCurriculumActivity() {
    return curriculumActivity;
  }

  public void setCurriculumActivity(CurriculumActivity curriculumActivity) {
    this.curriculumActivity = curriculumActivity;
  }

  public String getReferenceUrl() {
    return referenceUrl;
  }

  public void setReferenceUrl(String referenceUrl) {
    this.referenceUrl = referenceUrl;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here [AVINASH]
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof CurriculumActivityReference))
      return false;

    CurriculumActivityReference that = (CurriculumActivityReference) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
