package com.revature.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class TypeConversionUtil {

  public static float round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
  }

  /**
   * Method converts Any object to Long
   * 
   * @param value
   * @return Long converted value
   */
  public static Long toLong(Object value) {
    return value != null ? Long.parseLong(value.toString()) : null;
  }


  /**
   * Method converts Timestamp to LocalDateTime
   * 
   * @param date
   * @return LocalDateTime
   */
  public static LocalDateTime toLocalDateTime(Timestamp date) {
    return date != null ? date.toLocalDateTime() : null;
  }

  /**
   * Method converts Any object to Float
   * 
   * @param value
   * @return Float converted value
   */
  public static Float toFloat(Object value) {
    return value != null ? Float.parseFloat(value.toString()) : null;

  }

  /**
   * Method converts Any object to Integer
   * 
   * @param value
   * @return Integer converted value
   */
  public static Integer toInteger(Object value) {
    return value != null ? Integer.parseInt(value.toString()) : null;

  }

  /**
   * Method converts Any object to String
   * 
   * @param obj
   * @return String converted value
   */
  public static String toString(Object obj) {
    String value;
    if (obj == null)
      value = null;
    else if (obj instanceof String)
      value = "Y".equalsIgnoreCase(obj.toString()) ? "Y" : "N";
    else if (obj instanceof Integer)
      value = ((Integer) obj).compareTo(1) == 0 ? "Y" : "N";
    else if (obj instanceof BigInteger)
      value = ((BigInteger) obj).intValue() == 1 ? "Y" : "N";
    else
      value = Boolean.valueOf(obj.toString()) ? "Y" : "N";
    return value;
  }

  /**
   * To convert object into boolean.
   * 
   * @param oneOrZero
   * @return boolean
   */
  public static Boolean isYesOrNo(Object oneOrZero) {
    return Boolean.valueOf("1".equals(oneOrZero.toString())) ? true : false;
  }

  public static boolean toBool(Object value) {
    if (value == null)
      return false;

    String val = value.toString();
    return ("1".equalsIgnoreCase(val) || "yes".equalsIgnoreCase(val)
        || "true".equalsIgnoreCase(val));
  }
}
