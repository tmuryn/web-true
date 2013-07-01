package com.tiv.webtrue.dao.dto;

public enum Role {

  USER(1), ADMIN(2), EXPERT(3), MODERATOR(4);

  private Integer id;

  private Role(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


}
