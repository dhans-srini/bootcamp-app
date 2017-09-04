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

@Entity
@Table(name = "profile_assessment_contents")
public class ProfileAssessmentContent implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PROFILE_ASSESSMENT_ID")
  private ProfileAssessment profileAssessment;

  @ManyToOne()
  @JoinColumn(name = "VIDEO_ID")
  private Video video;

  @ManyToOne()
  @JoinColumn(name = "ASSESSMENT_ID")
  private Assessment assessment;

  @Column(name = "DISPLAY_ORDER")
  private Integer displayOrder;

  private String type;

  // ----------------------------------------------------- Getter Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProfileAssessment getProfileAssessment() {
    return profileAssessment;
  }

  public void setProfileAssessment(ProfileAssessment profileAssessment) {
    this.profileAssessment = profileAssessment;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Assessment getAssessment() {
    return assessment;
  }

  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
