package com.revature.vo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * This class using all controllers as service response.
 * 
 * @author uday
 */
public class ServiceResponse {

  private String statusCode;
  private String description;
  private Object data;

  public ServiceResponse() {
    super();
  }

  @Override
  public boolean equals(Object obj) {
    final boolean equal;
    if (this == obj) {
      equal = true;
    } else if (!(obj instanceof ServiceResponse)) {
      equal = false;
    } else {
      ServiceResponse other = (ServiceResponse) obj;
      equal = new EqualsBuilder().append(statusCode, other.statusCode)
          .append(description, other.description).append(data, other.data).isEquals();
    }
    return equal;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(statusCode).append(description).append(data)
        .toHashCode();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

}
