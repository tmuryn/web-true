package com.tiv.webtrue.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.ProfileDao;
import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.ProfileDTO;
import com.tiv.webtrue.core.service.AccountService;
import com.tiv.webtrue.core.service.ProfileService;

@Transactional
@Service
public class ProfileServiceImpl extends AbstractServiceImpl<ProfileDTO> implements ProfileService {

  @Autowired
  private ProfileDao profileDao;
  
  @Autowired
  private AccountService accountService;
  
  @Override
  public void register(AccountDTO account, ProfileDTO profile) throws AccountDuplicateException {
    AccountDTO savedAccount = accountService.getByEmail(account.getEmail());
    if (savedAccount!=null){
      throw new AccountDuplicateException();
    }
    
    accountService.save(account);
    profile.setAccountId(account.getId());
    save(profile);
  }

  @Override
  AbstractDao<ProfileDTO, Long> getDao() {
    return profileDao;
  }

}
