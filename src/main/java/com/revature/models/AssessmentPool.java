package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.utils.TypeConversionUtil;

/**
 * This POJO is used to map the assmt_pools table
 * 
 * @author Revature
 *
 */
@Entity
@Table(name = "assmt_pools")
public class AssessmentPool implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "ASSMT_ID")
  private Assessment assessment;

  @Column(name = "NAME")
  private String name;

  @Column(name = "MAX_QST_TO_DISPLAY")
  private Long maxQstnToDisplay;

  @Column(name = "DISPLAY_ORDER")
  private Long displayOrder;

  @OneToMany(mappedBy = "assessmentPool", fetch = FetchType.LAZY)
  private List<AsstPoolQuestion> asstPoolQuestions;


  @Transient
  private Long maxQstnToDisplayT;


  /**
   * This is a default constructor
   */
  public AssessmentPool() {
    /*
     * This is a default constructor. I need to declare explicitly an empty public constructor with
     * no argument because I also need the default one, and if I don't declare it , it won't be
     * available.
     */
  }

  public AssessmentPool(Long id) {
    this.id = id;
  }

  // ----------------------------------- Getter Setters
  public Long getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = TypeConversionUtil.toLong(id);
  }

  public Assessment getAssessment() {
    return assessment;
  }

  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
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

  public Long getMaxQstnToDisplay() {
    return maxQstnToDisplay;
  }

  public void setMaxQstnToDisplay(Long maxQstnToDisplay) {
    this.maxQstnToDisplay = maxQstnToDisplay;

  }

  public List<AsstPoolQuestion> getAsstPoolQuestions() {
    return asstPoolQuestions;
  }

  public void setAsstPoolQuestions(List<AsstPoolQuestion> asstPoolQuestions) {
    this.asstPoolQuestions = asstPoolQuestions;
  }

  // ----------------------------- Transient Getter setter

  public Long getMaxQstnToDisplayT() {
    return maxQstnToDisplayT;
  }

  public void setMaxQstnToDisplayT(Object maxQstnToDisplayT) {
    this.maxQstnToDisplayT = TypeConversionUtil.toLong(maxQstnToDisplayT);
  }


  // --------------------------------- Hash code Override

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
