package com.revature.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "profile_assessment")
public class ProfileAssessment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @Column(name = "CREATED_ON")
  private Date createdOn;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @Column(name = "MODIFIED_ON")
  private Date modifiedOn;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "profileAssessment")
  @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
  List<ProfileAssessmentContent> profileAssessmentContents;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id", nullable = false)
  private Organization organization;

  // ---------------------------------------------------- Transient

  @Transient
  private BigInteger orgId;

  @Transient
  private String createdByName;

  @Transient
  private Boolean isRootOrgQuiz;

  // ----------------------------------------------------- Getter Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(SystemUser createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public SystemUser getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(SystemUser modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public List<ProfileAssessmentContent> getProfileAssessmentContents() {
    return profileAssessmentContents;
  }

  public void setProfileAssessmentContents(
      List<ProfileAssessmentContent> profileAssessmentContents) {
    this.profileAssessmentContents = profileAssessmentContents;
  }



  // ---------------------------------------------------- Transient

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public String getCreatedByName() {
    return createdByName;
  }

  public void setCreatedByName(String createdByName) {
    this.createdByName = createdByName;
  }



  public BigInteger getOrgId() {
    return orgId;
  }

  public void setOrgId(BigInteger orgId) {
    this.orgId = orgId;
  }

  // hibernate resultset transformer
  public void setprofId(Object obj) {
    if (obj != null) {
      this.id = Long.parseLong(obj.toString());
    }
  }

  public Boolean isRootOrgQuiz() {
    return isRootOrgQuiz;
  }

  public void setRootOrgQuiz(Boolean isRootOrgQuiz) {
    this.isRootOrgQuiz = isRootOrgQuiz;
  }

  public void setActiveSts(Object ob) {
    isActive = Optional.ofNullable(ob).map(o -> "1".equals(o.toString())).orElse(false);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    if (!(obj instanceof ProfileAssessment)) {
      return false;
    }
    ProfileAssessment pa = (ProfileAssessment) obj;
    return new EqualsBuilder().append(this.id, pa.id).isEquals();
  }
}
