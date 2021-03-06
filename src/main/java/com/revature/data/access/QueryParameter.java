package com.revature.data.access;

public class QueryParameter<V> {

  private String name;
  private V value;

  public QueryParameter() {

  }

  public QueryParameter(String name, V value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

}
