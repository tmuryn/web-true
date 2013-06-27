package com.tiv.webtrue.web.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.model.ExpertInventation;
import com.tiv.webtrue.core.model.Profile;

public class RegistrationForm {

  private Account account = new Account();

  private Profile profile = new Profile();

  private ExpertInventation inventation = new ExpertInventation();

  @NotEmpty
  @Length(min=6, max=100)
  private String fullName;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public ExpertInventation getInventation() {
    return inventation;
  }

  public void setInventation(ExpertInventation inventation) {
    this.inventation = inventation;
  }



}
