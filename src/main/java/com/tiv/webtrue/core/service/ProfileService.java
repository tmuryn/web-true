package com.tiv.webtrue.core.service;

import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.ProfileDTO;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;


public interface ProfileService extends AbstractService<ProfileDTO> {

  void register(AccountDTO account, ProfileDTO profile) throws AccountDuplicateException;
}
