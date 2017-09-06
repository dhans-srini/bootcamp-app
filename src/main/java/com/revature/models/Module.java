package com.revature.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the modules database table.
 * 
 */
@Entity
@Table(name = "modules")
public class Module implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID")
  private Organization organization;

  @Column(name = "title")
  private String title;

  @Column(name = "tags")
  private String tags;

  @Column(name = "descriptions")
  private String description;

  @Column(name = "unique_key")
  private String uniqueKey;

  @Column(name = "show_discriptions")
  private Boolean showDiscriptions = false;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive = false;

  @Column(name = "duration")
  private Integer duration;

  @Column(name = "is_hidden")
  private Boolean isHidden = false;

  @Column(name = "is_scheduled")
  private Boolean isScheduled = false;

  @Column(name = "duration_uom")
  private String durationUom;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private Employee createdBy;

  @Column(name = "CREATED_ON")
  private Date createdOn;

  @Column(name = "parent_module_id")
  private Long parentModuleId;

  // ----------------------------- Constructor
  public Module() {
    // No arg cons
  }

  // ----------------------------------- Getter Setter

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUniqueKey() {
    return uniqueKey;
  }

  public void setUniqueKey(String uniqueKey) {
    this.uniqueKey = uniqueKey;
  }

  public Boolean getShowDiscriptions() {
    return showDiscriptions;
  }

  public void setShowDiscriptions(Boolean showDiscriptions) {
    this.showDiscriptions = showDiscriptions;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
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

  public Employee getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Employee createdBy) {
    this.createdBy = createdBy;
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

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here [AVINASH]
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Module))
      return false;

    Module that = (Module) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
