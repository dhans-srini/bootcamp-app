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
@Table(name = "org_subscribed_courses")
public class OrgSubscribedCourse implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  @Column(name = "course_super_parent_id")
  private Long courseSuperParentId;

  @Column(name = "subscribed_on")
  private Date subscribedOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id")
  private Organization organization;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "updated_by")
  private Employee updatedBy;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Long getCourseSuperParentId() {
    return courseSuperParentId;
  }

  public void setCourseSuperParentId(Long courseSuperParentId) {
    this.courseSuperParentId = courseSuperParentId;
  }

  public Date getSubscribedOn() {
    return subscribedOn;
  }

  public void setSubscribedOn(Date subscribedOn) {
    this.subscribedOn = subscribedOn;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Employee getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Employee updatedBy) {
    this.updatedBy = updatedBy;
  }



}
