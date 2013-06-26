package com.tiv.webtrue.web.controller;

import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.model.Profile;

public class RegistrationForm {

  private Account account = new Account();

  private Profile profile = new Profile();

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


}
