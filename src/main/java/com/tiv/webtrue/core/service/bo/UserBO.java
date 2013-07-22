package com.tiv.webtrue.core.service.bo;



public class UserBO {
 
  private String fullName;
  
  private String email;
  
  private String password;
  
  private String invitation;
  
  private String activationUrl;
  
  private String activationCode;
  
  private Long profileId;

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

  public String getInvitation() {
    return invitation;
  }

  public void setInvitation(String inventation) {
    this.invitation = inventation;
  }

  public String getActivationUrl() {
    return activationUrl;
  }

  public void setActivationUrl(String activationUrl) {
    this.activationUrl = activationUrl;
  }

  public String getActivationCode() {
    return activationCode;
  }

  public void setActivationCode(String activationCode) {
    this.activationCode = activationCode;
  }

  public Long getProfileId() {
    return profileId;
  }

  public void setProfileId(Long profileId) {
    this.profileId = profileId;
  }

  
  
  
}
