package com.revature.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATED_ON")
  private Date createdOn;

  private String description;

  @JsonIgnore
  @Column(name = "ENROLLMENT_SCORE")
  private Long enrollmentScore;

  @JsonIgnore
  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "MODIFIED_ON")
  private Date modifiedOn;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LVL_ID")
  private Level level;

  private String name;

  @Column(name = "COURSE_VERSION")
  private Integer courseVersion;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PARENT_VERSION_ID")
  private Course parentVersion;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID")
  private Organization organization;

  @Column(name = "DASHBOARD_FLAG")
  private Boolean dashboardFlag;

  @Column(name = "PRE_SIGNUP_FLAG")
  private Boolean preSignupFlag;

  @Column(name = "OVERRIDE_FLAG")
  private Boolean overRideFlag;

  @Column(name = "MODE")
  private Character mode;

  private String slugs;

  private String tags;

  @Column(name = "META_KEY_WORDS")
  private String metaKeyWord;

  @Column(name = "META_DESCRIPTION")
  private String metaDescription;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @JsonIgnore
  @Column(name = "LOGO_FILE_NAME")
  private String logoFileName;

  @JsonIgnore
  @Column(name = "LOGO_URL")
  private String logoUrl;

  @Column(name = "SUPER_PARENT_ID")
  private Long superParentId;

  @Column(name = "ENROLLMENT_ACTIVITY")
  private Integer enrollmentActivity;

  @Column(name = "COMPLETION_ACTIVITY")
  private Integer completionActivity;

  @Column(name = "IMAGE_UNIQUE_NAME")
  private String courseImageName;

  @Column(name = "IS_REQ_FOR_PUBLISH")
  private Boolean isReqForPublish;

  // ----------------------------------------------------------- Transient

  @Transient
  private Integer displayOrderT;

  @Transient
  private boolean draftRevision;

  @Transient
  private Long internViews;

  @Transient
  private String courseImageUrl;

  // -------------------------------------------------------- Getter Setter
  public Boolean getDashboardFlag() {
    return dashboardFlag;
  }

  public void setDashboardFlag(Boolean dashboardFlag) {
    this.dashboardFlag = dashboardFlag;
  }

  public Boolean getPreSignupFlag() {
    return preSignupFlag;
  }

  public void setPreSignupFlag(Boolean preSignupFlag) {
    this.preSignupFlag = preSignupFlag;
  }


  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Boolean getOverRideFlag() {
    return overRideFlag;
  }

  public void setOverRideFlag(Boolean overRideFlag) {
    if (overRideFlag == null)
      overRideFlag = false;
    this.overRideFlag = overRideFlag;
  }

  public Integer getCourseVersion() {
    return courseVersion;
  }

  public void setCourseVersion(Integer courseVersion) {
    this.courseVersion = courseVersion;
  }

  public Course getParentVersion() {
    return parentVersion;
  }

  public void setParentVersion(Course parentVersion) {
    this.parentVersion = parentVersion;
  }

  public String getSlugs() {
    return slugs;
  }

  public void setSlugs(String slugs) {
    this.slugs = slugs;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public Course() {}

  public Course(Long courseId) {
    this.id = courseId;
  }

  public Course(Long courseId, String courseName) {
    this.id = courseId;
    this.name = courseName;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getIsActive() {
    return isActive;
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

  public Date getCreatedOn() {
    return createdOn;
  }

  public Long getEnrollmentScore() {
    return enrollmentScore;
  }

  public void setEnrollmentScore(Long enrollmentScore) {
    this.enrollmentScore = enrollmentScore;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
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

  public String getLogoFileName() {
    return logoFileName;
  }

  public void setLogoFileName(String logoFileName) {
    this.logoFileName = logoFileName;
  }

  // * for hivernate result transformer
  public void setCourseId(BigDecimal courseId) {
    this.id = courseId.longValue();
  }

  public void setCourseDesc(Clob clob) throws Exception {
    if (clob != null) {
      this.description = clob.getSubString(1, (int) clob.length());
    }
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Character getMode() {
    return mode;
  }

  public void setMode(Character mode) {
    this.mode = mode;
  }

  public Long getSuperParentId() {
    return superParentId;
  }

  public void setSuperParentId(Long superParentId) {
    this.superParentId = superParentId;
  }

  public String getMetaKeyWord() {
    return metaKeyWord;
  }

  public void setMetaKeyWord(String metaKeyWord) {
    this.metaKeyWord = metaKeyWord;
  }

  public String getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(String metaDescription) {
    this.metaDescription = metaDescription;
  }

  public Integer getEnrollmentActivity() {
    return enrollmentActivity;
  }

  public void setEnrollmentActivity(Integer enrollmentActivity) {
    this.enrollmentActivity = enrollmentActivity;
  }

  public Integer getCompletionActivity() {
    return completionActivity;
  }

  public void setCompletionActivity(Integer completionActivity) {
    this.completionActivity = completionActivity;
  }

  public String getCourseImageName() {
    return courseImageName;
  }

  public void setCourseImageName(String courseImageName) {
    this.courseImageName = courseImageName;
  }

  public Boolean getIsReqForPublish() {
    return isReqForPublish;
  }

  public void setIsReqForPublish(Boolean isReqForPublish) {
    this.isReqForPublish = isReqForPublish;
  }

  // ----------------------------------------------- Transient Getter Setter
  public Integer getDisplayOrderT() {
    return displayOrderT;
  }

  public void setDisplayOrderT(Integer displayOrder) {
    this.displayOrderT = displayOrder;
  }

  public boolean isDraftRevision() {
    return draftRevision;
  }

  public void setDraftRevision(boolean draftRevision) {
    this.draftRevision = draftRevision;
  }

  public Long getInternViews() {
    return internViews;
  }

  public void setInternViews(Long internViews) {
    this.internViews = internViews;
  }

  public String getCourseImageUrl() {
    return courseImageUrl;
  }

  public void setCourseImageUrl(String courseImageUrl) {
    this.courseImageUrl = courseImageUrl;
  }

  // ----------------------- Override the Hash Code Here -----------------
  @Override
  public int hashCode() {
    Integer result = null;
    if (getId() != null) {
      result = Integer.parseInt(getId().toString());
    } else {
      result = new String().hashCode();
    }
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj != null && this.hashCode() == obj.hashCode()) {
      result = true;
    }
    return result;
  }
}
