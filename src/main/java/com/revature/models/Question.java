package com.revature.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
public class Question implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String title;

  @Column(name = "QSN_TEXT")
  private String qsnText;

  @ManyToOne
  @JoinColumn(name = "LVL_ID")
  private Level level;

  @JsonIgnore
  @Column(name = "CREATED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "MODIFIED_ON")
  private Date modifiedOn;

  @Column(name = "SKILL_POINTS")
  private Integer points;

  private Float score;

  @Column(name = "TAGS")
  private String tags;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id", nullable = false)
  private Organization organization;

  @Column(name = "DURATION_IN_SEC")
  private Integer durationInSec;

  @ManyToOne()
  @JoinColumn(name = "CAT_ID")
  private Category category;

  @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
  @Fetch(FetchMode.JOIN)
  private List<QsnAnswer> qsnAnswers;

  @ManyToOne(fetch = FetchType.EAGER)
  @Fetch(FetchMode.JOIN)
  @JoinColumn(name = "QSN_TYPE_ID")
  private QsnType qsnType;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @JsonIgnore
  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
  private List<AsstPoolQuestion> asstQuestions;

  // -----------transient variables for services start------
  @Transient
  private Long slNo;

  @Transient
  private String catName;

  @Transient
  private String lvlName;

  @Transient
  private Long internAssessmentQuestionId;

  @Transient
  private List<QsnAnswer> internAnswers;

  @Transient
  private String durString;

  @Transient
  private Long internId;

  @Transient
  private Integer order;

  @JsonIgnore
  @Transient
  private Boolean isSelected;

  @JsonIgnore
  @Transient
  private Boolean isSticky;

  @JsonIgnore
  @Transient
  private int rowCount;

  @Transient
  private BigInteger orgId;
  // -----------transient variables for services end------

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public Question() {}

  public Question(Long qsnId) {
    this.id = qsnId;
  }

  public Long getId() {
    return id;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
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

  public String getQsnText() {
    return qsnText;
  }

  public void setQsnText(String qsnText) {
    this.qsnText = qsnText;
  }

  public List<QsnAnswer> getQsnAnswers() {
    return qsnAnswers;
  }

  public void setQsnAnswers(List<QsnAnswer> qsnAnswers) {
    this.qsnAnswers = qsnAnswers;
  }

  public SystemUser getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(SystemUser modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Long getSlNo() {
    return slNo;
  }

  public void setSlNo(Long slNo) {
    this.slNo = slNo;
  }

  public List<AsstPoolQuestion> getAsstQuestions() {
    return asstQuestions;
  }

  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }

  public String getLvlName() {
    return lvlName;
  }

  public void setLvlName(String lvlName) {
    this.lvlName = lvlName;
  }

  public void setAsstQuestions(List<AsstPoolQuestion> asstQuestions) {
    this.asstQuestions = asstQuestions;
  }

  public SystemUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(SystemUser createdBy) {
    this.createdBy = createdBy;
  }

  public QsnType getQsnType() {
    return qsnType;
  }

  public void setQsnType(QsnType qsnType) {
    this.qsnType = qsnType;
  }

  public List<QsnAnswer> getInternAnswers() {
    return internAnswers;
  }

  public void setInternAnswers(List<QsnAnswer> internAnswers) {
    this.internAnswers = internAnswers;
  }

  public Long getInternAssessmentQuestionId() {
    return internAssessmentQuestionId;
  }

  public void setInternAssessmentQuestionId(Long internAssessmentQuestionId) {
    this.internAssessmentQuestionId = internAssessmentQuestionId;
  }

  public Boolean getIsSelected() {
    return isSelected;
  }

  public void setIsSelected(Boolean isSelected) {
    this.isSelected = isSelected;
  }

  public Boolean getIsSticky() {
    return isSticky;
  }

  public void setIsSticky(Boolean isSticky) {
    this.isSticky = isSticky;
  }

  public Long getInternId() {
    return internId;
  }

  public void setInternId(Long internId) {
    this.internId = internId;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Integer getDurationInSec() {
    return durationInSec;
  }

  public void setDurationInSec(Integer durationInSec) {
    this.durationInSec = durationInSec;
  }

  public int getRowCount() {
    return rowCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  public BigInteger getOrgId() {
    return orgId;
  }

  public void setOrgId(BigInteger orgId) {
    this.orgId = orgId;
  }

  public String getDurString() {
    String durString = "0h 00m 00s";
    if (durationInSec != null) {
      long hrs = durationInSec / (60 * 60);
      long sec2 = durationInSec % (60 * 60);
      long min = sec2 / 60;
      long secf = sec2 % 60;
      durString = hrs + "h " + min + "m " + secf + "s";
    }
    return durString;
  }

  public void setDurString(String durString) {
    if (durString != null) {
      int sec = 0;
      String durStr[] = durString.replaceAll("[hms]", "").split(" ");
      sec = Integer.parseInt(durStr[2]);
      sec += Integer.parseInt(durStr[1]) * 60;
      sec += Integer.parseInt(durStr[0]) * 60 * 60;
      this.durationInSec = sec;
    }
    this.durString = durString;
  }

  public void setQsnId(Object obj) {
    if (obj != null) {
      this.id = Long.parseLong(obj.toString());
    }
  }

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
