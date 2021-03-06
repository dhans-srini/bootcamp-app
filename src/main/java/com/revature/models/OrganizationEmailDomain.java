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
import com.revature.utils.TypeConversionUtil;

/**
 * This is an Organization Email Domain Entity class
 * 
 * @since v3
 */
@Entity
@Table(name = "org_email_domains")
@XmlRootElement
public class OrganizationEmailDomain implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORG_ID", nullable = false)
  private Organization organization;

  @Column(name = "DOMAIN", nullable = false, unique = true)
  private String domain;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive = true;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATED_BY", nullable = false)
  private Employee createdBy;

  @Column(name = "CREATED_ON", nullable = false)
  @JsonSerialize(using = JsonDateSerializer.class)
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  private Date createdOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "UPDATED_BY")
  private Employee updatedBy;

  @Column(name = "UPDATED_ON")
  @JsonSerialize(using = JsonDateSerializer.class)
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  private Date updatedOn;


  @Transient
  private String editedFlag;

  public Long getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = TypeConversionUtil.toLong(id);
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
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

  public Employee getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Employee updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
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
