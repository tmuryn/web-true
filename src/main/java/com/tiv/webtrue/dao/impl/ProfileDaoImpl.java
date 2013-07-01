package com.tiv.webtrue.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.dao.ProfileDao;
import com.tiv.webtrue.dao.dto.ProfileDTO;

@Repository
public class ProfileDaoImpl extends AbstractDaoImpl<ProfileDTO,Long> implements ProfileDao {

  protected ProfileDaoImpl() {
    super(ProfileDTO.class);
  }
}
