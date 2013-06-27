package com.tiv.webtrue.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tiv.webtrue.core.dao.dto.AccountDTO;
import com.tiv.webtrue.core.service.AbstractService;
import com.tiv.webtrue.core.service.AccountService;

@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class AccountServiceImplTest extends AbstractServiceTest<AccountDTO> {

  @Autowired
  AccountService service;

  protected AccountDTO createModel() {
    AccountDTO account = new AccountDTO();
    account.setEmail("www@mail.ru");
    return account;
  }

  @Override
  protected AbstractService<AccountDTO> getService() {
    return service;
  }

}
