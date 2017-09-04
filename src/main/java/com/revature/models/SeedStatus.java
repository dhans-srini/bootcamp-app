package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "seed_status")
@XmlRootElement
public class SeedStatus implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "code", nullable = false, unique = true)
  private String code;

  @Column(name = "status_label", nullable = false)
  private String label;

  @Column(name = "remarks", nullable = true)
  private String remarks;

  @Column(name = "is_active", nullable = false)
  private String isActive;

  public SeedStatus() {}

  public SeedStatus(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getIsActive() {
    return isActive;
  }

  public void setIsActive(String isActive) {
    this.isActive = isActive;
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
