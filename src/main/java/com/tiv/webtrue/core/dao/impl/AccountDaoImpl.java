package com.tiv.webtrue.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.core.dao.AccountDao;
import com.tiv.webtrue.core.model.Account;


@Repository
public class AccountDaoImpl extends AbstractDaoImpl<Account, Long> implements AccountDao{

  public AccountDaoImpl() {
    super(Account.class);
  }

}
