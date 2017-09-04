package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This model is used to map the assessment and question.
 * 
 * @author dhans s
 *
 */
@Entity
@Table(name = "assmt_pool_qns")
public class AsstPoolQuestion implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "ASST_POOL_ID")
  private AssessmentPool assessmentPool;

  @ManyToOne
  @JoinColumn(name = "QSN_ID")
  private Question question;

  @Column(name = "qsn_order")
  private Integer order;

  @Column(name = "is_sticky")
  private Boolean isSticky;

  // -------------------------------------- Transient
  @JsonIgnore
  @Transient
  private Boolean isSelected;

  @JsonIgnore
  @Transient
  private int rowCount;

  // ------------------------------------- Constructor
  public AsstPoolQuestion() {
    super();
  }

  /**
   * @param id
   */
  public AsstPoolQuestion(Long id) {
    super();
    this.id = id;
  }

  // --------------------------------------- Getter Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }



  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public Boolean getIsSticky() {
    return isSticky;
  }

  public void setIsSticky(Boolean isSticky) {
    this.isSticky = isSticky;
  }

  public Boolean getIsSelected() {
    return isSelected;
  }

  public void setIsSelected(Boolean isSelected) {
    this.isSelected = isSelected;
  }

  public int getRowCount() {
    return rowCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  public AssessmentPool getAssessmentPool() {
    return assessmentPool;
  }

  public void setAssessmentPool(AssessmentPool assessmentPool) {
    this.assessmentPool = assessmentPool;
  }

  // --------------------------------- Hash code Override

  @Override
  public int hashCode() {
    Integer result;
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
