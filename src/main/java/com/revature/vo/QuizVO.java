package com.revature.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.revature.utils.TypeConversionUtil;

/**
 * Created on 05/09/2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizVO {
  private Long id;
  private String title;

  public QuizVO() {
    // Default constructor
  }

  public Long getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = TypeConversionUtil.toLong(id);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int hashCode() {
    return id != null ? id.intValue() : super.hashCode();
  }

  // ------------------- equals customized here
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof QuizVO))
      return false;

    QuizVO that = (QuizVO) obj;
    return this.id == null ? false : this.id.equals(that.getId());
  }
}
