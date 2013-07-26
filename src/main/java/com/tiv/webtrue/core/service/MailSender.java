package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.service.bo.Email;


public interface MailSender {

  public void send(Email email);
}
