package com.revature.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "assessments")
public class Assessment implements Serializable, Comparable<Assessment> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "TITLE")
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LVL_ID")
  private Level level;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  @Column(name = "NO_OF_ATTEMPTS")
  private Integer noOfAttempts;

  @Column(name = "PASS_PERCENTAGE")
  private Long passPercentage;

  private String tags;

  private String slug;

  private String description;

  private String instructions;

  @Column(name = "meta_tags")
  private String metaTags;

  @Column(name = "meta_description")
  private String metaDescription;

  @Column(name = "TIMER_ENABLE")
  private Boolean timerEnable;

  @Column(name = "SHOW_EXPLANATION")
  private Boolean showExplanation;

  @Column(name = "SHUFFLE_QSN")
  private Boolean shuffleQsn;

  @Column(name = "SHUFFLE_ANS")
  private Boolean shuffleAns;

  private Integer version;

  private String mode;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID")
  private Organization organization;

  @Column(name = "SUPER_PARENT_ID")
  private Long superParentId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PARENT_VERSION_ID")
  private Assessment parent;

  @Column(name = "DISPLAY_CORRECT_ANSWER")
  private Boolean displayCorrectAnswer;

  @Column(name = "DISPLAY_SCORE")
  private Boolean displayScore;

  @Column(name = "PRE_SIGNUP_FLAG")
  private Boolean preSignupFlag;

  @Column(name = "DASHBOARD_FLAG")
  private Boolean dashboardFlag;

  @Column(name = "OVERRIDE_FLAG")
  private Boolean overrideFlag;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @JsonIgnore
  @Column(name = "CREATED_ON")
  private Timestamp createdOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @Column(name = "MODIFIED_ON")
  private Timestamp modifiedOn;

  @OneToMany(mappedBy = "assessment", fetch = FetchType.LAZY)
  private List<AssessmentPool> assessmentPools;


  @Column(name = "ACTIVITY_POINTS")
  private Integer activityPoints;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @Column(name = "NO_OF_QSN_TO_SHOW")
  private Integer noOfQsnToShow;

  @Column(name = "IS_STICKY_ENABLED")
  private Boolean isStickyEnabled;

  @Column(name = "IS_IMAGE_UPLOADED")
  private Boolean isImageUploaded = false;

  @Column(name = "IS_REQ_FOR_PUBLISH")
  private Boolean isReqForPublish;


  /* ============transient values start ========== */
  @Transient
  private BigInteger orgId;

  @Transient
  @JsonIgnore
  private Long qsnCount;

  @Transient
  private String lvlName;

  @Transient
  private String catName;

  @Transient
  private String createdByUserName;

  @Transient
  private String updatedByUserName;

  @Transient
  private String duration;

  @Transient
  private Long parentId;

  @Transient
  private Integer parentVersion;

  @Transient
  private Long createdById;

  @Transient
  private Boolean isChildAvailable;

  @Transient
  private Integer displayOrderT;

  @Transient
  private Integer skillPoint;

  @Transient
  private Long internViews;

  @Transient
  private boolean selected;

  @Transient
  private String iconUrl;

  @Transient
  private String iconUniqueName;

  @Transient
  private boolean iconDeleted;

  @Transient
  private String asmtFlag;

  @Transient
  private Long levelId;

  @Transient
  private List<AsstPoolQuestion> asstQuestions;

  @Transient
  private String eqType;

  @Transient
  private BigInteger suprPrntId;



  /* ============transient values end ========== */

  /* ========constructors start========== */

  public Assessment() {}

  public Assessment(Long asmtId) {
    this.id = asmtId;
  }

  public Assessment(Long assessmentId, String assessmentTitle, Integer noOfAttempts2,
      String status) {
    this.id = assessmentId;
    this.title = assessmentTitle;
    this.noOfAttempts = noOfAttempts2;
  }

  /* ========constructors end========== */

  /* ========getters and setters start========== */
  public Long getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = id != null ? Long.valueOf(id.toString()) : null;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Level getLevel() {
    return level;
  }


  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Integer getNoOfAttempts() {
    return noOfAttempts;
  }

  public void setNoOfAttempts(Integer noOfAttempts) {
    this.noOfAttempts = noOfAttempts;
  }

  public Long getPassPercentage() {
    return passPercentage;
  }

  public void setPassPercentage(Long passPercentage) {
    this.passPercentage = passPercentage;
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

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getMetaTags() {
    return metaTags;
  }

  public void setMetaTags(String metaTags) {
    this.metaTags = metaTags;
  }

  public String getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(String metaDescription) {
    this.metaDescription = metaDescription;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public Boolean getTimerEnable() {
    return timerEnable;
  }

  public void setTimerEnable(Boolean timerEnable) {
    this.timerEnable = timerEnable;
  }

  public Boolean getShowExplanation() {
    return showExplanation;
  }

  public void setShowExplanation(Boolean showExplanation) {
    this.showExplanation = showExplanation;
  }

  public Boolean getShuffleQsn() {
    return shuffleQsn;
  }

  public void setShuffleQsn(Boolean shuffleQsn) {
    this.shuffleQsn = shuffleQsn;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Boolean getShuffleAns() {
    return shuffleAns;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public Long getCreatedById() {
    return createdById;
  }

  public void setCreatedById(Long createdById) {
    this.createdById = createdById;
  }

  public Integer getParentVersion() {
    return parentVersion;
  }

  public void setParentVersion(Integer parentVersion) {
    this.parentVersion = parentVersion;
  }

  public Long getSuperParentId() {
    return superParentId;
  }

  public void setSuperParentId(Long superParentId) {
    this.superParentId = superParentId;
  }

  public Assessment getParent() {
    return parent;
  }

  public void setParent(Assessment parent) {
    this.parent = parent;
  }

  public void setShuffleAns(Boolean shuffleAns) {
    this.shuffleAns = shuffleAns;
  }

  public Boolean getDisplayCorrectAnswer() {
    return displayCorrectAnswer;
  }

  public void setDisplayCorrectAnswer(Boolean displayCorrectAnswer) {
    this.displayCorrectAnswer = displayCorrectAnswer;
  }

  public Boolean getDisplayScore() {
    return displayScore;
  }

  public void setDisplayScore(Boolean displayScore) {
    this.displayScore = displayScore;
  }

  public Boolean getPreSignupFlag() {
    return preSignupFlag;
  }

  public void setPreSignupFlag(Boolean preSignupFlag) {
    this.preSignupFlag = preSignupFlag;
  }

  public Boolean getDashboardFlag() {
    return dashboardFlag;
  }

  public void setDashboardFlag(Boolean dashboardFlag) {
    this.dashboardFlag = dashboardFlag;
  }

  public Boolean getOverrideFlag() {
    return overrideFlag;
  }

  public void setOverrideFlag(Boolean overrideFlag) {
    this.overrideFlag = overrideFlag;
  }

  public SystemUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(SystemUser createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Timestamp createdOn) {
    this.createdOn = createdOn;
  }

  public SystemUser getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(SystemUser modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Timestamp getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Timestamp modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public List<AssessmentPool> getAssessmentPools() {
    return assessmentPools;
  }

  public void setAssessmentPools(List<AssessmentPool> assessmentPools) {
    this.assessmentPools = assessmentPools;


  }

  public Long getQsnCount() {
    return qsnCount;
  }

  public void setQsnCount(Long qsnCount) {
    this.qsnCount = qsnCount;
  }

  public Integer getActivityPoints() {
    return activityPoints;
  }

  public void setActivityPoints(Integer activityPoints) {
    this.activityPoints = activityPoints;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Boolean getIsStickyEnabled() {
    return isStickyEnabled;
  }

  public void setIsStickyEnabled(Boolean isStickyEnabled) {
    this.isStickyEnabled = isStickyEnabled;
  }

  public Boolean getIsReqForPublish() {
    return isReqForPublish;
  }

  public void setIsReqForPublish(Boolean isReqForPublish) {
    this.isReqForPublish = isReqForPublish;
  }

  public BigInteger getOrgId() {
    return orgId;
  }

  public void setOrgId(BigInteger orgId) {
    this.orgId = orgId;
  }

  public Integer getNoOfQsnToShow() {
    return noOfQsnToShow;
  }

  public void setNoOfQsnToShow(Integer noOfQsnToShow) {
    this.noOfQsnToShow = noOfQsnToShow;
  }

  public String getLvlName() {
    return lvlName;
  }

  public void setLvlName(String lvlName) {
    this.lvlName = lvlName;
  }

  public String getCreatedByUserName() {
    return createdByUserName;
  }

  public void setCreatedByUserName(String createdByUserName) {
    this.createdByUserName = createdByUserName;
  }

  public Boolean getIsChildAvailable() {
    return isChildAvailable;
  }

  public void setIsChildAvailable(Boolean isChildAvailable) {
    this.isChildAvailable = isChildAvailable;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getDuration() {
    if (duration == null && asstQuestions != null && !asstQuestions.isEmpty()) {
      duration = "0h 00m 00s";
      long dur = 0;
      for (AsstPoolQuestion aq : asstQuestions) {

        dur += aq.getQuestion().getDurationInSec();
      }
      if (dur != 0) {
        long hrs = dur / (60 * 60);
        long sec2 = dur % (60 * 60);
        long min = sec2 / 60;
        long secf = sec2 % 60;
        duration = hrs + "h " + min + "m " + secf + "s";
      }
    }
    return duration;
  }



  public String getEqType() {
    return eqType;
  }

  public void setEqType(String eqType) {
    this.eqType = eqType;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getUpdatedByUserName() {
    return updatedByUserName;
  }

  public void setUpdatedByUserName(String updatedByUserName) {
    this.updatedByUserName = updatedByUserName;
  }

  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }

  /* ========getters and setters end========== */

  /* ========setters for hibernate start========== */
  public void setAsmtId(Object obj) {
    if (obj != null) {
      this.id = Long.parseLong(obj.toString());
    }
  }

  public void setQnCount(Object obj) {
    if (obj != null) {
      this.qsnCount = Long.parseLong(obj.toString());
    }
  }

  public void setPassPer(Object obj) {
    if (obj != null) {
      this.passPercentage = Long.parseLong(obj.toString());
    }
  }

  public void setParId(Object obj) {
    if (obj != null) {
      this.parentId = Long.parseLong(obj.toString());
    }
  }

  public void setSupParId(Object obj) {
    if (obj != null) {
      this.superParentId = Long.parseLong(obj.toString());
    }
  }

  public void setMo(Object ob) {
    if (ob != null) {
      this.mode = ob.toString();
    }
  }

  public Integer getDisplayOrderT() {
    return displayOrderT;
  }

  public void setDisplayOrderT(Integer displayOrder) {
    this.displayOrderT = displayOrder;
  }

  public void setCreId(Object obj) {
    if (obj != null) {
      this.createdById = Long.parseLong(obj.toString());
    }
  }

  public void setParVer(Object obj) {
    if (obj != null) {
      this.parentVersion = Integer.parseInt(obj.toString());
    }
  }

  public void setHaveChild(Object obj) {
    if (obj != null) {
      this.isChildAvailable = obj.toString().equals("1") ? true : false;
    }
  }

  public Integer getSkillPoint() {
    return skillPoint;
  }

  public void setSkillPoint(Integer skillPoint) {
    this.skillPoint = skillPoint;
  }

  public Long getInternViews() {
    return internViews;
  }

  public void setInternViews(Long internViews) {
    this.internViews = internViews;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public String getIconUniqueName() {
    return iconUniqueName;
  }

  public void setIconUniqueName(String iconUniqueName) {
    this.iconUniqueName = iconUniqueName;
  }

  public boolean isIconDeleted() {
    return iconDeleted;
  }

  public void setIconDeleted(boolean iconDeleted) {
    this.iconDeleted = iconDeleted;
  }

  public String getAsmtFlag() {
    return asmtFlag;
  }

  public void setAsmtFlag(String asmtFlag) {
    this.asmtFlag = asmtFlag;
  }

  public Long getLevelId() {
    return levelId;
  }

  public void setLevelId(Object levelId) {
    this.levelId = levelId != null ? Long.valueOf(levelId.toString()) : null;
  }

  public Boolean getIsImageUploaded() {
    return isImageUploaded;
  }

  public void setIsImageUploaded(Boolean isImageUploaded) {
    this.isImageUploaded = isImageUploaded;
  }

  public List<AsstPoolQuestion> getAsstQuestions() {
    return asstQuestions;
  }

  public void setAsstQuestions(List<AsstPoolQuestion> asstQuestions) {
    this.asstQuestions = asstQuestions;
  }

  public void setActiveSts(Object obj) {
    isActive = Optional.ofNullable(obj).map(o -> "1".equals(o.toString())).orElse(false);
  }


  public BigInteger getSuprPrntId() {
    return suprPrntId;
  }

  public void setSuprPrntId(BigInteger suprPrntId) {
    this.suprPrntId = suprPrntId;
  }

  /* ========setters for hibernate end========== */
  @Override
  public int hashCode() {
    Integer result = null;
    if (getEqType() == null && getId() != null) {
      result = Integer.parseInt(getId().toString());
    } else if (getEqType() != null && "superParId".equals(getEqType())) {
      result = Integer.parseInt(getSuperParentId().toString());
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

  @Override
  public int compareTo(Assessment o) {
    return this.createdOn.compareTo(o.createdOn);
  }
}
