package com.revature.vo;

import java.util.Date;

public class ModuleVO {
  private Long id;
  private String title;
  private String tags;
  private String uniqueKey;
  private String descriptions;
  private Boolean showDiscriptions;
  private Boolean isScheduled;
  private Integer duration;
  private Long organizationId;
  private Boolean isActive;
  private Boolean isHidden;
  private String durationUom;
  private Long empId;
  private Date createdOn;
  private Long parentModuleId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getUniqueKey() {
    return uniqueKey;
  }

  public void setUniqueKey(String uniqueKey) {
    this.uniqueKey = uniqueKey;
  }

  public String getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(String descriptions) {
    this.descriptions = descriptions;
  }

  public Boolean getShowDiscriptions() {
    return showDiscriptions;
  }

  public void setShowDiscriptions(Boolean showDiscriptions) {
    this.showDiscriptions = showDiscriptions;
  }

  public Boolean getIsScheduled() {
    return isScheduled;
  }

  public void setIsScheduled(Boolean isScheduled) {
    this.isScheduled = isScheduled;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Boolean getIsHidden() {
    return isHidden;
  }

  public void setIsHidden(Boolean isHidden) {
    this.isHidden = isHidden;
  }

  public String getDurationUom() {
    return durationUom;
  }

  public void setDurationUom(String durationUom) {
    this.durationUom = durationUom;
  }

  public Long getEmpId() {
    return empId;
  }

  public void setEmpId(Long empId) {
    this.empId = empId;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Long getParentModuleId() {
    return parentModuleId;
  }

  public void setParentModuleId(Long parentModuleId) {
    this.parentModuleId = parentModuleId;
  }

}
