package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.model.Profile;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;


public interface ProfileService extends AbstractService<Profile> {

  void register(Account account, Profile profile) throws AccountDuplicateException;
}
