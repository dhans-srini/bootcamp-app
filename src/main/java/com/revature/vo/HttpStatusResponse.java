package com.revature.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Response class for public http requests
 * 
 * @since v2.10
 */
@JsonInclude(Include.NON_NULL)
public class HttpStatusResponse {

  private int statusCode;
  private String description;
  private Object data;

  /**
   * Default constructor
   */
  public HttpStatusResponse() {
    super();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int i) {
    this.statusCode = i;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}
