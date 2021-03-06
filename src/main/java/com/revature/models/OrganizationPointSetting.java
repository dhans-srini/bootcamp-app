package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This model is used to map the organization point settings
 * 
 * @author dhans s
 *
 */
@Entity
@Table(name = "org_point_settings")
public class OrganizationPointSetting implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id", nullable = false)
  private Organization organization;

  @Column(name = "SCORE")
  private Long score;

  @Column(name = "DESCRIPTION")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "point_setting_id", nullable = false)
  private PointSetting pointSetting;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PointSetting getPointSetting() {
    return pointSetting;
  }

  public void setPointSetting(PointSetting pointSetting) {
    this.pointSetting = pointSetting;
  }
}
