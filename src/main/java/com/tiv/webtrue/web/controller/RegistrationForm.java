package com.tiv.webtrue.web.controller;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {


  @NotEmpty
  @Length(min=6, max=100)
  private String fullName;
  
  @NotEmpty
  @Email
  private String email;
  
  @NotEmpty
  @Length(min=6 , max=12)
  private String password;
  
  private String inventation;
  
  @AssertTrue
  private boolean accept;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getInventation() {
    return inventation;
  }

  public void setInventation(String inventation) {
    this.inventation = inventation;
  }

  public boolean isAccept() {
    return accept;
  }

  public void setAccept(boolean accept) {
    this.accept = accept;
  }
  
  

  

}
