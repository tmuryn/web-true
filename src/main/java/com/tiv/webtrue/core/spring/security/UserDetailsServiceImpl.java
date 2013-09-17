package com.tiv.webtrue.core.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tiv.webtrue.core.service.AccountService;
import com.tiv.webtrue.dao.AccountRoleDao;
import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.AccountRoleDTO;
import com.tiv.webtrue.dao.dto.Role;

@Service("myUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private AccountService accountService;
  
  static {
    GrantedAuthority authorityAdmin = new GrantedAuthorityImpl("ADMIN");
    GrantedAuthority authorityGuest = new GrantedAuthorityImpl("GUEST");
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AccountDTO accountDTO = accountService.getByEmail(username);
    
    if (accountDTO == null) {
      throw new UsernameNotFoundException("Wrong username or password");
    }
    
    Collection<AccountRoleDTO> roleDTOs = accountService.getRoles(accountDTO);
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (AccountRoleDTO accountRoleDTO : roleDTOs) {
      Role role = Role.valueOf(accountRoleDTO.getRoleId());
      authorities.add(new GrantedAuthorityImpl(role.toString()));
    }
    
    //authorities.add(new GrantedAuthorityImpl(Role.ADMIN.toString()));
    UserDetailsImpl matchingUser = new UserDetailsImpl(username, accountDTO.getPassword(), authorities, accountDTO);

    return matchingUser;
  }

}
