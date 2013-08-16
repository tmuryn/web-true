package com.tiv.webtrue.core.service.impl;

import java.util.Collection;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.AccountDao;
import com.tiv.webtrue.dao.AccountRoleDao;
import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.AccountRoleDTO;
import com.tiv.webtrue.dao.dto.Role;
import com.tiv.webtrue.core.service.AccountService;

@Service
public class AccountServiceImpl extends AbstractServiceImpl<AccountDTO> implements AccountService {
  
  @Autowired
  private AccountDao dao;
  
  @Autowired
  private AccountRoleDao roleDao;

  @Override
  public AccountDTO getByEmail(String email) {
    AccountDTO account = dao.findFirst(Restrictions.eq("email", email));
    return account;
  }

  @Override
  AbstractDao<AccountDTO, Long> getDao() {
    return (AbstractDao<AccountDTO, Long>)dao;
  }

  @Override
  public AccountDTO getByActivationCode(String activationCode) {
    return getDao().findFirst(Restrictions.eq("activationCode", activationCode));
  }

  @Override
  public void activate(Long id) {
      AccountDTO accountDTO = get(id);
      if (accountDTO!=null){
        accountDTO.setActivated(true);
        save(accountDTO);
      }
      
  }

  @Override
  public void save(AccountDTO accountDTO, Role... roles) {
      
      save(accountDTO);
      Collection<AccountRoleDTO> roleDTOs = getRoles(accountDTO);
      for (AccountRoleDTO accountRoleDTO : roleDTOs) {
        roleDao.delete(accountRoleDTO);
      }
     
      for (Role role : roles) {
        AccountRoleDTO roleDTO = new AccountRoleDTO();
        roleDTO.setAccountId(accountDTO.getId());
        roleDTO.setRoleId(role.getId());
        roleDao.save(roleDTO);
      }
      
  }

  public Collection<AccountRoleDTO> getRoles(AccountDTO accountDTO) {
    Collection<AccountRoleDTO> roleDTOs = roleDao.find(Restrictions.eq("accountId", accountDTO.getId()));
    return roleDTOs;
  }

  
}
