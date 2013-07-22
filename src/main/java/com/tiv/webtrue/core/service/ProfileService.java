package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.service.bo.InventationBO;
import com.tiv.webtrue.core.service.bo.UserBO;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;
import com.tiv.webtrue.core.service.impl.InvalidInvantationCode;
import com.tiv.webtrue.dao.dto.ProfileDTO;


public interface ProfileService extends AbstractService<ProfileDTO> {

  void register(UserBO registrationBO) throws AccountDuplicateException, InvalidInvantationCode;

  UserBO activate(String activationCode);
  
  ProfileDTO getByAccountId(Long activationCode);
  
  void sendConfirmationEmail();

  void invite(InventationBO bo);
  
  UserBO getByInventationCode(String invantationCode);
}
