package com.tiv.webtrue.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.service.AbstractService;
import com.tiv.webtrue.core.service.AccountService;

@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class AccountServiceImplTest extends AbstractServiceTest<Account> {

  @Autowired
  AccountService service;

  protected Account createModel() {
    Account account = new Account();
    account.setEmail("www@mail.ru");
    return account;
  }

  @Override
  protected AbstractService<Account> getService() {
    return service;
  }

}
