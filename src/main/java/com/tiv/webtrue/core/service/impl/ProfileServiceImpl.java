package com.tiv.webtrue.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.core.dao.AbstractDao;
import com.tiv.webtrue.core.dao.ProfileDao;
import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.model.Profile;
import com.tiv.webtrue.core.service.AccountService;
import com.tiv.webtrue.core.service.ProfileService;

@Transactional
@Service
public class ProfileServiceImpl extends AbstractServiceImpl<Profile> implements ProfileService {

  @Autowired
  private ProfileDao profileDao;
  
  @Autowired
  private AccountService accountService;
  
  @Override
  public void register(Account account, Profile profile) throws AccountDuplicateException {
    Account savedAccount = accountService.getByEmail(account.getEmail());
    if (savedAccount!=null){
      throw new AccountDuplicateException();
    }
    
    accountService.save(account);
    profile.setAccountId(account.getId());
    save(profile);
  }

  @Override
  AbstractDao<Profile, Long> getDao() {
    return profileDao;
  }

}
