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

import com.revature.shared.dto.response.Video;
import com.revature.shared.models.Assessment;

/**
 * The persistent class for the curriculum_activities database table.
 * 
 */
@Entity
@Table(name = "curriculum_activities")
public class CurriculumActivity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "video_id")
  private Video video;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "quiz_id")
  private Assessment quiz;

  @Column(name = "title")
  private String title;

  @Column(name = "type")
  private String type;

  @Column(name = "descriptions")
  private String description;

  @Column(name = "is_submission_req")
  private Boolean isSubmissionReq;

  @Column(name = "show_discriptions")
  private Boolean showDiscriptions = false;

  @Column(name = "score")
  private Integer score;

  @Column(name = "is_hidden")
  private Boolean isHidden = false;

  @Column(name = "is_scheduled")
  private Boolean isScheduled = false;

  @Column(name = "duration_uom")
  private String durationUom;

  @Column(name = "duration")
  private Integer duration;

  // ----------------------------- Constructor
  public CurriculumActivity() {
    // No arg cons
  }

  // ----------------------------------- Getter Setter

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Assessment getQuiz() {
    return quiz;
  }

  public void setQuiz(Assessment quiz) {
    this.quiz = quiz;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getIsSubmissionReq() {
    return isSubmissionReq;
  }

  public void setIsSubmissionReq(Boolean isSubmissionReq) {
    this.isSubmissionReq = isSubmissionReq;
  }

  public Boolean getShowDiscriptions() {
    return showDiscriptions;
  }

  public void setShowDiscriptions(Boolean showDiscriptions) {
    this.showDiscriptions = showDiscriptions;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Boolean getIsHidden() {
    return isHidden;
  }

  public void setIsHidden(Boolean isHidden) {
    this.isHidden = isHidden;
  }

  public Boolean getIsScheduled() {
    return isScheduled;
  }

  public void setIsScheduled(Boolean isScheduled) {
    this.isScheduled = isScheduled;
  }

  public String getDurationUom() {
    return durationUom;
  }

  public void setDurationUom(String durationUom) {
    this.durationUom = durationUom;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here [AVINASH]
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof CurriculumActivity))
      return false;

    CurriculumActivity that = (CurriculumActivity) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
