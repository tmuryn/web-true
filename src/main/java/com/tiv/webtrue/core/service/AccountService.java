package com.tiv.webtrue.core.service;

import com.tiv.webtrue.dao.dto.AccountDTO;

public interface AccountService extends AbstractService<AccountDTO> {
  
	public AccountDTO getByEmail(String email);
}
