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

@Entity
@Table(name = "org_deactivated_quizes")
public class OrgInactiveQuiz implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Assessment quiz;

  @Column(name = "quiz_super_parent_id")
  private Long quizSuperParentId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id")
  private Organization organization;

  @Column(name = "deactivated_on")
  private Date inactivatedOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deactivated_by")
  private Employee inactivatedBy;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Assessment getQuiz() {
    return quiz;
  }

  public void setQuiz(Assessment quiz) {
    this.quiz = quiz;
  }

  public Long getQuizSuperParentId() {
    return quizSuperParentId;
  }

  public void setQuizSuperParentId(Long quizSuperParentId) {
    this.quizSuperParentId = quizSuperParentId;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Date getInactivatedOn() {
    return inactivatedOn;
  }

  public void setInactivatedOn(Date inactivatedOn) {
    this.inactivatedOn = inactivatedOn;
  }

  public Employee getInactivatedBy() {
    return inactivatedBy;
  }

  public void setInactivatedBy(Employee inactivatedBy) {
    this.inactivatedBy = inactivatedBy;
  }

}
