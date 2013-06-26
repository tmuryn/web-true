package com.tiv.webtrue.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.core.dao.AccountRoleDao;
import com.tiv.webtrue.core.model.AccountRole;

@Repository
public class AccountRoleDaoImpl extends AbstractDaoImpl<AccountRole, Long> implements AccountRoleDao {

  protected AccountRoleDaoImpl() {
    super(AccountRole.class);
  }

}
