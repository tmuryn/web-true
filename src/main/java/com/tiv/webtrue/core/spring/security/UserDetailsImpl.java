package com.tiv.webtrue.core.spring.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tiv.webtrue.dao.dto.AccountDTO;

public class UserDetailsImpl implements UserDetails {

  private static final long serialVersionUID = -6509897037222767090L;
  
  private Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
  private String password;
  private String username;
  private AccountDTO accountDTO;
   
  public UserDetailsImpl(String username, String password, Collection<GrantedAuthority> authorities, AccountDTO accountDTO){
   this.username = username;
   this.password = password;
   this.authorities = authorities;
   this.accountDTO = accountDTO;
  }
  
  public Collection<GrantedAuthority> getAuthorities() {
   return this.authorities;
  }
  
  public String getPassword() {
   return this.password;
  }
  
  public String getUsername() {
   return this.username;
  }
  
  public boolean isAccountNonExpired() {
   return true;
  }
  
  public boolean isAccountNonLocked() {
   return true;
  }
  
  public boolean isCredentialsNonExpired() {
   return true;
  }
  
  public boolean isEnabled() {
   return true;
  }

  public AccountDTO getAccountDTO() {
    return accountDTO;
  }

  public void setAccountDTO(AccountDTO accountDTO) {
    this.accountDTO = accountDTO;
  }
  
  
  
}
