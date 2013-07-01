package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.service.bo.RegistrationBO;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;
import com.tiv.webtrue.core.service.impl.InvalidInvantationCode;
import com.tiv.webtrue.dao.dto.ProfileDTO;


public interface ProfileService extends AbstractService<ProfileDTO> {

  void register(RegistrationBO registrationBO) throws AccountDuplicateException, InvalidInvantationCode;
}
