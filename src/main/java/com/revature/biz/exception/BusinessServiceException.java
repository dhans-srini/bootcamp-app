package com.revature.biz.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception class meant to be throw by service impls. It's meant primarily as a validation or
 * illegal-argument exception. It might also be thrown if a complex operation needs to be rolled
 * back.
 *
 * @Modified Muthu G.K
 */
public class BusinessServiceException extends Exception {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String code;
  private String msg;
  private String errorDetail;
  private boolean paymentException;

  // ---------------------------------- Constructor
  /**
   * empty throw
   */
  public BusinessServiceException() {
    super();
  }

  /**
   * This is for throw the message
   * 
   * @param message
   */
  public BusinessServiceException(String msg, Throwable exception) {
    super(msg, exception);
  }

  /**
   * This is for throw the message with cause
   * 
   * @param message
   * @param cause
   */
  public BusinessServiceException(Throwable exception) {
    super(exception);
  }

  /**
   * This is for throw the cause
   * 
   * @param cause
   */
  public BusinessServiceException(String message) {
    super(message);
  }

  // --------------------------------------- Getter
  public HttpStatus getStatus() {
    return status;
  }

  public String getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public boolean isPaymentException() {
    return paymentException;
  }

  public String getErrorDetail() {
    return errorDetail;
  }


  // --------------------------------------- Setter
  public BusinessServiceException setStatus(HttpStatus status) {
    this.status = status;
    return this;
  }

  public BusinessServiceException setCode(String code) {
    this.code = code;
    return this;
  }

  public BusinessServiceException setMsg(String msg) {
    this.msg = msg;
    return this;
  }

  public BusinessServiceException setPaymentException(boolean paymentException) {
    this.paymentException = paymentException;
    return this;
  }

  public BusinessServiceException setErrorDetail(String errorDetail) {
    this.errorDetail = errorDetail;
    return this;
  }

  // --------------------------------- custom override
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
