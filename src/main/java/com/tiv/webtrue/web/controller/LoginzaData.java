package com.tiv.webtrue.web.controller;

import javax.persistence.Entity;

@Entity
public class LoginzaData {

  private String identity;
  
  private String email;

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
  
  
}
