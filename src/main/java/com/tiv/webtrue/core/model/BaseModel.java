package com.tiv.webtrue.core.model;



public class BaseModel {

  protected Long id;
  private String uid;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

}
