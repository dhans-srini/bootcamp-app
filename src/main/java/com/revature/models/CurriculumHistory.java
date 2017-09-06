package com.revature.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.utils.JsonDateDeserializer24Hrs;
import com.revature.utils.JsonDateSerializer24Hrs;
import com.revature.utils.LocalDateAttributeConverter;

/**
 * The persistent class for the curriculum_histories database table.
 * 
 */
@Entity
@Table(name = "curriculum_histories")
public class CurriculumHistory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "curriculum_id")
  private Curriculum curriculum;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "updated_by")
  private Employee updatedBy;

  @Convert(converter = LocalDateAttributeConverter.class)
  @JsonSerialize(using = JsonDateSerializer24Hrs.class)
  @JsonDeserialize(using = JsonDateDeserializer24Hrs.class)
  @Column(name = "updated_on")
  private LocalDateTime updatedOn;

  // ----------------------------- Constructor
  public CurriculumHistory() {
    // No arg cons
  }

  // ----------------------------------- Getter Setter

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Curriculum getCurriculum() {
    return curriculum;
  }

  public void setCurriculum(Curriculum curriculum) {
    this.curriculum = curriculum;
  }

  public Employee getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Employee updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(LocalDateTime updatedOn) {
    this.updatedOn = updatedOn;
  }

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here [AVINASH]
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof CurriculumHistory))
      return false;

    CurriculumHistory that = (CurriculumHistory) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
