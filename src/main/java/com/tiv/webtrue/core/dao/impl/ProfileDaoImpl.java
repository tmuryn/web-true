package com.tiv.webtrue.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.core.dao.ProfileDao;
import com.tiv.webtrue.core.dao.dto.ProfileDTO;

@Repository
public class ProfileDaoImpl extends AbstractDaoImpl<ProfileDTO,Long> implements ProfileDao {

  protected ProfileDaoImpl() {
    super(ProfileDTO.class);
  }
}
