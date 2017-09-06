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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.utils.CustomJsonDateDeserializer;
import com.revature.utils.JsonDateSerializer;

/**
 * This is an Organization Coupon Code Entity class
 * 
 * @since v3
 */
@Entity
@Table(name = "org_coupon_codes")
@XmlRootElement
public class OrganizationCouponCode implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID", nullable = false)
  private Organization organization;

  @Column(name = "COUPON_CODE", nullable = false, unique = true)
  private String couponCode;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive = true;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY")
  private Employee createdBy;

  @Column(name = "CREATED_ON")
  @JsonSerialize(using = JsonDateSerializer.class)
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  private Date createdOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modified_by")
  private Employee modifiedBy;

  @Column(name = "modified_on")
  @JsonSerialize(using = JsonDateSerializer.class)
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  private Date modifiedOn;

  @Column(name = "valid_from")
  @JsonSerialize(using = JsonDateSerializer.class)
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  private Date validFrom;

  @Column(name = "valid_to")
  @JsonSerialize(using = JsonDateSerializer.class)
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  private Date validTo;

  @Transient
  private String editedFlag;

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

  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Employee getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Employee createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Employee getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(Employee modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public String getEditedFlag() {
    return editedFlag;
  }

  public void setEditedFlag(String editedFlag) {
    this.editedFlag = editedFlag;
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
  public int hashCode() {
    return new HashCodeBuilder().append(this.id).hashCode();
  }

}
