package com.tiv.webtrue.dao.dto;

import java.util.HashMap;
import java.util.Map;

public enum Role {

  USER(1), ADMIN(2), EXPERT(3), MODERATOR(4);

  private Integer id;
  
  private static Map<Integer, Role> map = new HashMap<Integer, Role>();

  private Role(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  public static Role valueOf(Integer id){
    if (map.isEmpty()){
      Role[] roles = values();
      for (Role role : roles) {
        map.put(role.id, role);
      }
    }
    Role role = map.get(id);
    if (role==null){
      role = USER;
    }
    return role;
  }
  
  


}
