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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This Model is used to map the options table
 * 
 * @author dhans s
 *
 */
@Entity
@Table(name = "qn_answers")
public class QsnAnswer implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  private String answer;

  private Boolean iscorrect;

  private String explanation;

  private Integer grade;

  @Column(name = "IS_STICKY")
  private Boolean isSticky;

  @Column(name = "OPT_ORDER")
  private Integer order;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "QSN_ID")
  private Question question;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Boolean getIscorrect() {
    return iscorrect;
  }

  public void setIscorrect(Boolean iscorrect) {
    this.iscorrect = iscorrect;
  }

  public String getExplanation() {
    return explanation;
  }

  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  public Boolean getIsSticky() {
    return isSticky;
  }

  public void setIsSticky(Boolean isSticky) {
    this.isSticky = isSticky;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

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
