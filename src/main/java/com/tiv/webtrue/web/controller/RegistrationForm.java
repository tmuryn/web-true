package com.tiv.webtrue.web.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.tiv.webtrue.core.dao.dto.AccountDTO;
import com.tiv.webtrue.core.dao.dto.ExpertInventationDTO;
import com.tiv.webtrue.core.dao.dto.ProfileDTO;

public class RegistrationForm {

  private AccountDTO account = new AccountDTO();

  private ProfileDTO profile = new ProfileDTO();

  private ExpertInventationDTO inventation = new ExpertInventationDTO();

  @NotEmpty
  @Length(min=6, max=100)
  private String fullName;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public AccountDTO getAccount() {
    return account;
  }

  public void setAccount(AccountDTO account) {
    this.account = account;
  }

  public ProfileDTO getProfile() {
    return profile;
  }

  public void setProfile(ProfileDTO profile) {
    this.profile = profile;
  }

  public ExpertInventationDTO getInventation() {
    return inventation;
  }

  public void setInventation(ExpertInventationDTO inventation) {
    this.inventation = inventation;
  }



}
