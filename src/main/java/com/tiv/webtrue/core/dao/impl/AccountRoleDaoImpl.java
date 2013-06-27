package com.tiv.webtrue.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.core.dao.AccountRoleDao;
import com.tiv.webtrue.core.dao.dto.AccountRoleDTO;

@Repository
public class AccountRoleDaoImpl extends AbstractDaoImpl<AccountRoleDTO, Long> implements AccountRoleDao {

  protected AccountRoleDaoImpl() {
    super(AccountRoleDTO.class);
  }

}
