package com.tiv.webtrue.core.service.bo;

import java.util.HashMap;
import java.util.Map;

public class Email {
  
  private String to;
  private String subject;
  private String template;
  private Map<String, Object> model = new HashMap<String, Object>(0);
  private boolean isHtml;
  private String from = "wwilt@mail.ru";

  public Email(String to, String subject, String template) {
    super();
    this.to = to;
    this.subject = subject;
    this.template = template;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String filename) {
    this.template = filename;
  }

  public Map<String, Object> getModel() {
    return model;
  }

  public void setModel(Map<String, Object> map) {
    this.model = map;
  }

  public boolean isHtml() {
    return isHtml;
  }

  public void setHtml(boolean isHtml) {
    this.isHtml = isHtml;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }
  
  


}
