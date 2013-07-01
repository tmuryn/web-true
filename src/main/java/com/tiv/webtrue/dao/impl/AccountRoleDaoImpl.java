package com.tiv.webtrue.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.dao.AccountRoleDao;
import com.tiv.webtrue.dao.dto.AccountRoleDTO;

@Repository
public class AccountRoleDaoImpl extends AbstractDaoImpl<AccountRoleDTO, Long> implements AccountRoleDao {

  protected AccountRoleDaoImpl() {
    super(AccountRoleDTO.class);
  }

}
