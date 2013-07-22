package com.tiv.webtrue.core.service;

import java.util.Collection;

import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.AccountRoleDTO;
import com.tiv.webtrue.dao.dto.Role;

public interface AccountService extends AbstractService<AccountDTO> {

  public AccountDTO getByEmail(String email);

  public AccountDTO getByActivationCode(String activationCode);

  public void activate(Long id);
  
  public void save(AccountDTO accountDTO,Role... roles);
  
  public Collection<AccountRoleDTO> getRoles(AccountDTO accountDTO);
}
