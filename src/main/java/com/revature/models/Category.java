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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.utils.PropertiesFileUtils;

@Entity
@Table(name = "categories")
@XmlRootElement
public class Category implements Serializable {
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
  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "MODIFIED_ON")
  private Date modifiedOn;

  private String name;

  @Column(name = "DISPLAY_ORDER")
  private Long displayOrder;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private SystemUser createdBy;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MODIFIED_BY")
  private SystemUser modifiedBy;

  @Column(name = "IMAGE_UNIQUE_NAME")
  private String imageUniqueName;

  @Column(name = "LOGO_URL")
  private String logoUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "org_id", nullable = false)
  private Organization organization;

  public Category() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getDescription() {
    return description;
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

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Long displayOrder) {
    this.displayOrder = displayOrder;
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

  public String getImageUniqueName() {
    return imageUniqueName;
  }

  public void setImageUniqueName(String imageUniqueName) {
    this.imageUniqueName = imageUniqueName;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public String getLogoUrl() {
    if (getId() != null) {
      String baseLocation = PropertiesFileUtils.getValue("application", "base_download_url");
      String imageUrl = PropertiesFileUtils.getValue("application", "category_image_download_url");
      if (getImageUniqueName() != null) {
        imageUrl = imageUrl.replace("{id}",
            getImageUniqueName().substring(0, getImageUniqueName().lastIndexOf(".")) + "_64"
                + getImageUniqueName().substring(getImageUniqueName().lastIndexOf(".")));
        this.logoUrl = baseLocation + imageUrl;
      }
    }
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  /* =========hibernate setters start====== */
  public void setCatId(Object obj) {
    if (obj != null) {
      this.id = Long.parseLong(obj.toString());
    }
  }
  /* =========hibernate setters end====== */

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
