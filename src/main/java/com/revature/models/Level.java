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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "levels")
public class Level implements Serializable, Comparable<Level> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String description;

  @JsonIgnore
  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  private String name;

  @ManyToOne
  @JoinColumn(name = "pre_requisite_level")
  private Level preRequisiteLevel;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @JsonIgnore
  @Column(name = "CREATED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @JsonIgnore
  @Column(name = "MODIFIED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modifiedOn;

  // -------------- Transient Variables [ Starts ] ---------

  @Transient
  private boolean selectedLevel;

  @Transient
  private boolean statusWithCategory;

  // -------------- Transient Variables [ End ] ---------

  /**
   * Default no-arg constructor.
   */
  public Level() {
    super();
  }

  /**
   * Construct Level with specified id.
   * 
   * @param id
   */
  public Level(Long id) {
    this.id = id;
  }

  /**
   * Constructor Level with specified id and name.
   * 
   * @param id
   * @param name
   */
  public Level(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getIsActive() {
    return this.isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Level getPreRequisiteLevel() {
    return preRequisiteLevel;
  }

  public void setPreRequisiteLevel(Level preRequisiteLevel) {
    this.preRequisiteLevel = preRequisiteLevel;
  }

  public SystemUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(SystemUser createdBy) {
    this.createdBy = createdBy;
  }

  public SystemUser getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(SystemUser modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }



  // -------------- Transient Getter & Setter [ Starts ] ---------

  public boolean isSelectedLevel() {
    return selectedLevel;
  }

  public void setSelectedLevel(boolean selectedLevel) {
    this.selectedLevel = selectedLevel;
  }

  public boolean isStatusWithCategory() {
    return statusWithCategory;
  }

  public void setStatusWithCategory(boolean statusWithCategory) {
    this.statusWithCategory = statusWithCategory;
  }

  // -------------- Transient Getter & Setter [ End ] ---------

  /* ============hibernate setters start=========== */
  public void setLvlId(Object obj) {
    if (obj != null) {
      this.id = Long.parseLong(obj.toString());
    }
  }
  /* ============hibernate setters end=========== */

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(id).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj != null && this.hashCode() == obj.hashCode()) {
      result = true;
    }
    return result;
  }

  @Override
  public int compareTo(Level rhs) {
    long lhsValue = id != null ? id : 0;
    long rhsValue = rhs != null && rhs.id != null ? rhs.id : 0;

    return NumberUtils.compare(lhsValue, rhsValue);
  }

}
