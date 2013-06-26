package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.model.Profile;


public interface ProfileService extends AbstractService<Profile> {

  void registration(Account account, Profile profile);
}
