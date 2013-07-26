package com.tiv.webtrue.core.service.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.tiv.webtrue.core.service.MailSender;
import com.tiv.webtrue.core.service.bo.Email;

@Service
public class MailSenderImpl implements MailSender {

  private static final String ENCODING = "UTF-8";

  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private VelocityEngine velocityEngine;

  // TODO Move to configuration
  private Executor executor = Executors.newFixedThreadPool(3);

  @Override
  public void send(final Email email) {

    executor.execute(new Runnable() {

      @Override
      public void run() {
        doSend(email);
      }

    });
  }

  protected void doSend(final Email email) {

    MimeMessagePreparator preparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setSubject(email.getSubject());
        message.setTo(email.getTo());
        message.setFrom(email.getFrom());
        String text =
            VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, email.getTemplate(),
                ENCODING, email.getModel());
        message.setText(text, email.isHtml());
      }
    };
    
    this.mailSender.send(preparator);

  }


}
