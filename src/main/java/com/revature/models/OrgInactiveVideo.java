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
@Table(name = "org_deactivated_videos")
public class OrgInactiveVideo implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "video_id")
  private Video video;

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

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
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
