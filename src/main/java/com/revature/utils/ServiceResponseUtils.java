package com.revature.utils;

import static com.revature.utils.ServiceConstants.DATA_RETRIEVAL_SUCCESS_CODE;
import static com.revature.utils.ServiceConstants.DATA_RETRIEVAL_SUCCESS_MESSAGE;

import java.io.Serializable;

import com.revature.vo.HttpStatusResponse;
import com.revature.vo.ServiceResponse;

/**
 * This class used to manage the service response object for all controller.
 * 
 * @author uday
 * 
 */
public class ServiceResponseUtils implements Serializable {

  private static final long serialVersionUID = 1L;
  private static ServiceResponse serviceResponse;
  private static HttpStatusResponse httpResponse;

  /**
   * This method used to get dataResponse as output.
   * 
   * @param code code
   * @param description description
   * @param type type
   * @return serviceResponse
   */
  public static ServiceResponse dataResponse(String code, String description, Object type) {
    serviceResponse = new ServiceResponse();
    serviceResponse.setStatusCode(code);
    serviceResponse.setDescription(description);
    serviceResponse.setData(type);
    return serviceResponse;

  }

  /**
   * Convenience method for generating a data-retrieval success response.
   * 
   * @param data The response data.
   * @return {@link ServiceResponse}
   */
  public static ServiceResponse dataRetrievalSuccessResponse(Object data) {
    return dataResponse(DATA_RETRIEVAL_SUCCESS_CODE, DATA_RETRIEVAL_SUCCESS_MESSAGE, data);
  }


  /**
   * Method returns the response object with code and description.
   * 
   * @param code - Status code
   * @param description - Response despcription
   * @return httpResponse
   */
  public static HttpStatusResponse setHttpResponse(int code, String description) {
    httpResponse = new HttpStatusResponse();
    httpResponse.setStatusCode(code);
    httpResponse.setDescription(description);
    return httpResponse;

  }

  /**
   * Method returns the response object with code,data and description.
   * 
   * @param code - Status code
   * @param description - Response despcription
   * @param data - Actual data
   * @return httpResponse
   */
  public static HttpStatusResponse setHttpResponse(int code, String description, Object data) {
    httpResponse = new HttpStatusResponse();
    httpResponse.setStatusCode(code);
    httpResponse.setDescription(description);
    httpResponse.setData(data);
    return httpResponse;

  }

}
