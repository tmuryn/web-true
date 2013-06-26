package com.tiv.webtrue.core.service.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiv.webtrue.core.dao.AbstractDao;
import com.tiv.webtrue.core.dao.AccountDao;
import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.service.AccountService;

@Service
public class AccountServiceImpl extends AbstractServiceImpl<Account> implements AccountService {
  
  @Autowired
  private AccountDao dao;

  @Override
  public Account getByEmail(String email) {
    Account account = dao.findFirst(Restrictions.eq("email", email));
    return account;
  }

  @Override
  AbstractDao<Account, Long> getDao() {
    return (AbstractDao<Account, Long>)dao;
  }

  
}
