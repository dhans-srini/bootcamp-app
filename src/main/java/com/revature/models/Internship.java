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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "internships")
public class Internship implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String name;

  private String description;

  private String instruction;

  @JsonIgnore
  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LVL_ID")
  private Level level;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  @Column(name = "DISPLAY_ORDER")
  private Integer displayOrder;

  @Column(name = "MODE")
  private String mode;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @JsonIgnore
  @Column(name = "CREATED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @JsonIgnore
  @Column(name = "MODIFIED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modifiedOn;

  @JsonIgnore
  @Column(name = "ENROLLMENT_SCORE")
  private Integer enrollmentScore;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID")
  private Organization organization;

  @Column(name = "DURATION")
  private Integer duration;

  @JsonIgnore
  @Column(name = "INTERNSHIP_TYPE")
  private Character type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PARENT_VERSION_ID")
  private Internship parentVersion;

  @Column(name = "INTERNSHIP_VERSION")
  private Integer internshipVersion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ENROLL_ASSMT_ID")
  private Assessment assessment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRE_REQ_INTSHP")
  private Internship prerequestInternship;

  private String slugs;

  private String tags;

  @Column(name = "META_KEYS")
  private String metaKeys;

  @Column(name = "META_DESC")
  private String metaDescription;

  @Column(name = "SUPER_PARENT_ID")
  private Long superParentId;

  @Column(name = "MENTOR_NOTE_DES")
  private String mentorNoteDes;

  @Column(name = "ENROLLMENT_ACTIVITY")
  private Integer enrollmentActivity;

  @Column(name = "COMPLETION_ACTIVITY")
  private Integer completionActivity;

  @Column(name = "IS_DIVES_UNLOCKED")
  private Boolean isDivesUnlocked;

  @Column(name = "IS_REQ_FOR_PUBLISH")
  private Boolean isReqForPublish;

  // ----------------------------------------------- @Transient Values

  @Transient
  private Integer durationHrsT;

  @Transient
  private Integer durationMinT;

  public Internship() {
    // default constructor
  }

  public Internship(Long id) {
    this.id = id;
  }

  // ---------------------------------------------------- GETTER SETTER
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }



  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setInternshipId(Object internshipId) {
    if (internshipId != null) {
      this.id = Long.parseLong(internshipId.toString());
    }
  }

  public Integer getEnrollmentScore() {
    return enrollmentScore;
  }

  public void setEnrollmentScore(Integer enrollmentScore) {
    this.enrollmentScore = enrollmentScore;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {

    if (duration == null || duration <= 0) {
      this.durationHrsT = 0;
      this.durationMinT = 0;
    } else {
      durationHrsT = duration / 60;
      durationMinT = duration % 60;
    }
    this.duration = duration;
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

  public Character getType() {
    return type;
  }

  public void setType(Character type) {
    this.type = type;
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

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Level getLevel() {
    return level;
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

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getMetaKeys() {
    return metaKeys;
  }

  public void setMetaKeys(String metaKeys) {
    this.metaKeys = metaKeys;
  }

  public String getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(String metaDescription) {
    this.metaDescription = metaDescription;
  }

  public String getSlugs() {
    return slugs;
  }

  public void setSlugs(String slugs) {
    this.slugs = slugs;
  }

  public Integer getInternshipVersion() {
    return internshipVersion;
  }

  public void setInternshipVersion(Integer internshipVersion) {
    this.internshipVersion = internshipVersion;
  }

  public Assessment getAssessment() {
    return assessment;
  }

  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
  }

  public Internship getPrerequestInternship() {
    return prerequestInternship;
  }

  public void setPrerequestInternship(Internship prerequestInternship) {
    this.prerequestInternship = prerequestInternship;
  }

  public Internship getParentVersion() {
    return parentVersion;
  }

  public void setParentVersion(Internship parentVersion) {
    this.parentVersion = parentVersion;
  }

  public Long getSuperParentId() {
    return superParentId;
  }

  public void setSuperParentId(Long superParentId) {
    this.superParentId = superParentId;
  }

  public String getMentorNoteDes() {
    return mentorNoteDes;
  }

  public void setMentorNoteDes(String mentorNoteDes) {
    this.mentorNoteDes = mentorNoteDes;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  // ------------------------------------------ Transient GETTER and SETTER

  public Integer getDurationHrsT() {
    if (duration != null && duration > 0) {
      this.durationHrsT = duration / 60;
    } else
      this.durationHrsT = null;
    return durationHrsT;
  }

  public void setDurationHrsT(Integer durationHrsT) {
    if (durationHrsT != null) {
      duration = 0;
      duration += (durationHrsT * 60);
    }
    this.durationHrsT = durationHrsT;
  }

  public Integer getDurationMinT() {
    if (duration != null && duration > 0) {
      this.durationMinT = duration % 60;
    } else
      this.durationMinT = null;
    return durationMinT;
  }

  public void setDurationMinT(Integer durationMinT) {
    if (durationMinT != null) {
      if (duration == null)
        duration = 0;
      duration += durationMinT;
    }
    this.durationMinT = durationMinT;
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

  public Boolean getIsDivesUnlocked() {
    return isDivesUnlocked;
  }

  public void setIsDivesUnlocked(Boolean isDivesUnlocked) {
    this.isDivesUnlocked = isDivesUnlocked;
  }

  public Boolean getIsReqForPublish() {
    return isReqForPublish;
  }

  public void setIsReqForPublish(Boolean isReqForPublish) {
    this.isReqForPublish = isReqForPublish;
  }

  // --------------------------------------------------- Hash code Override

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
