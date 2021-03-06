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
 * The persistent class for the curriculums database table.
 * 
 */
@Entity
@Table(name = "curriculums")
public class Curriculum implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "title")
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID")
  private Organization organization;

  @Column(name = "descriptions")
  private String description;

  @Column(name = "unique_key")
  private String uniqueKey;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive = false;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private Employee createdBy;

  @Column(name = "CREATED_ON")
  private Date createdOn;

  @Column(name = "mode")
  private String mode;

  // ----------------------------- Constructor
  public Curriculum() {
    // No arg cons
  }

  // ----------------------------------- Getter Setter

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

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
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

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
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

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here [AVINASH]
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Curriculum))
      return false;

    Curriculum that = (Curriculum) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
