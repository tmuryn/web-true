package com.tiv.webtrue.core.dao.dto;

public enum RoleDTO {

  USER(1), ADMIN(2), EXPERT(3), MODERATOR(4);

  private Integer id;

  private RoleDTO(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


}
