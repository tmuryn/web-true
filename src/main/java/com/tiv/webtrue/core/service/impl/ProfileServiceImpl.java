package com.tiv.webtrue.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.ProfileDao;
import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.ProfileDTO;
import com.tiv.webtrue.web.controller.RegistrationForm;
import com.tiv.webtrue.core.service.AccountService;
import com.tiv.webtrue.core.service.ProfileService;
import com.tiv.webtrue.core.service.bo.RegistrationBO;

@Transactional
@Service
public class ProfileServiceImpl extends AbstractServiceImpl<ProfileDTO> implements ProfileService {

  @Autowired
  private ProfileDao profileDao;
  
  @Autowired
  private AccountService accountService;
  
  @Override
  public void register(RegistrationBO registrationBO) throws AccountDuplicateException, InvalidInvantationCode {
    AccountDTO savedAccount = accountService.getByEmail(registrationBO.getEmail());
    if (savedAccount!=null){
      throw new AccountDuplicateException();
    }
    
    if (registrationBO.getInvitation()!=null && !registrationBO.getInvitation().isEmpty()){
      // TODO change to InventationService
      if (!"555".contains(registrationBO.getInvitation())){
        throw new InvalidInvantationCode();
      }
    }
    
    AccountDTO account = new AccountDTO();
    account.setEmail(registrationBO.getEmail());
    account.setPassword(registrationBO.getPassword());
    accountService.save(account);
    
    ProfileDTO profile = new ProfileDTO();
    profile.setAccountId(account.getId());
    profile.setFullName(registrationBO.getFullName());
    
    save(profile);
  }

  @Override
  AbstractDao<ProfileDTO, Long> getDao() {
    return profileDao;
  }

}
