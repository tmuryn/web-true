package com.tiv.webtrue.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.core.dao.AccountDao;
import com.tiv.webtrue.core.dao.dto.AccountDTO;


@Repository
public class AccountDaoImpl extends AbstractDaoImpl<AccountDTO, Long> implements AccountDao{

  public AccountDaoImpl() {
    super(AccountDTO.class);
  }

}
