package com.tiv.webtrue.core.service.bo;

public class InventationBO {

  private String email;
  
  private Long CategoryId;

  private String code;
  
  private String registrationUrl;
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getCategoryId() {
    return CategoryId;
  }

  public void setCategoryId(Long categoryId) {
    CategoryId = categoryId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getRegistrationUrl() {
    return registrationUrl;
  }

  public void setRegistrationUrl(String registrationUrl) {
    this.registrationUrl = registrationUrl;
  }
  
  
}
