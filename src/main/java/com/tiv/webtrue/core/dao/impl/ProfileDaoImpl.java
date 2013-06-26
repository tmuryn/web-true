package com.tiv.webtrue.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.core.dao.ProfileDao;
import com.tiv.webtrue.core.model.Profile;

@Repository
public class ProfileDaoImpl extends AbstractDaoImpl<Profile,Long> implements ProfileDao {

  protected ProfileDaoImpl() {
    super(Profile.class);
  }
}
