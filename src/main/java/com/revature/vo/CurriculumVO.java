package com.revature.vo;

import static java.util.Optional.ofNullable;

import java.util.Date;

public class CurriculumVO {

  private Long curriculumId;
  private String title;
  private String description;
  private String uniqueName;
  private boolean isActive;
  private String mode;
  private Date createdOn;
  private String createdBy;

  /* Getter Setter starts here */

  public Long getCurriculumId() {
    return curriculumId;
  }

  public void setCurriculumId(Object curriculumId) {
    ofNullable(curriculumId).ifPresent(o -> this.curriculumId = Long.parseLong(o.toString()));
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUniqueName() {
    return uniqueName;
  }

  public void setUniqueName(String uniqueName) {
    this.uniqueName = uniqueName;
  }
  
  /* Getter Setter ends here */



}
