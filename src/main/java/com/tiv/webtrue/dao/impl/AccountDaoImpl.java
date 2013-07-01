package com.tiv.webtrue.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.dao.AccountDao;
import com.tiv.webtrue.dao.dto.AccountDTO;


@Repository
public class AccountDaoImpl extends AbstractDaoImpl<AccountDTO, Long> implements AccountDao{

  public AccountDaoImpl() {
    super(AccountDTO.class);
  }

}
