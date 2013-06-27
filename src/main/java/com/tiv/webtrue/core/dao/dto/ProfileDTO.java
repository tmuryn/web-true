package com.tiv.webtrue.core.dao.dto;

public class ProfileDTO extends BaseModelDTO {
  
  private Long accountId;
  private String fullName;

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }  


}
