package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.model.Account;

public interface AccountService extends AbstractService<Account> {
  
	public Account getByEmail(String email);
}
