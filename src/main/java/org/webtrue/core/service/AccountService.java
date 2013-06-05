package org.webtrue.core.service;

import org.webtrue.core.model.Account;

public interface AccountService extends CommonModelCRUD<Account> {
	public Account getByEmail(String email);
}
