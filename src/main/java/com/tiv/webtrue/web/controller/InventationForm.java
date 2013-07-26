package com.tiv.webtrue.web.controller;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class InventationForm {
  
  @Email
  @NotEmpty
  private String email;

  @AssertTrue
  private boolean accept;
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isAccept() {
    return accept;
  }

  public void setAccept(boolean accept) {
    this.accept = accept;
  }
}
