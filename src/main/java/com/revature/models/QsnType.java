package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the TBL_SEED_QSN_TYPES database table.
 * 
 */
@Entity
@Table(name = "seed_qn_types")
public class QsnType implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String code;

  @Column(name = "QSN_TYPE")
  private String qsnType;

  private String remarks;

  @JsonIgnore
  @OneToMany(mappedBy = "qsnType", fetch = FetchType.LAZY)
  private List<Question> adminQuestions;

  public QsnType() {}

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

  public String getQsnType() {
    return qsnType;
  }

  public void setQsnType(String qsnType) {
    this.qsnType = qsnType;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public List<Question> getAdminQuestions() {
    return adminQuestions;
  }

  public void setAdminQuestions(List<Question> adminQuestions) {
    this.adminQuestions = adminQuestions;
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
