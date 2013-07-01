package com.tiv.webtrue.core.service.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.AccountDao;
import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.core.service.AccountService;

@Service
public class AccountServiceImpl extends AbstractServiceImpl<AccountDTO> implements AccountService {
  
  @Autowired
  private AccountDao dao;

  @Override
  public AccountDTO getByEmail(String email) {
    AccountDTO account = dao.findFirst(Restrictions.eq("email", email));
    return account;
  }

  @Override
  AbstractDao<AccountDTO, Long> getDao() {
    return (AbstractDao<AccountDTO, Long>)dao;
  }

  
}
