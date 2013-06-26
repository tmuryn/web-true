package com.tiv.webtrue.core.model;

public class Article extends BaseModel {
  
  private String title;
  private String content;
  private String expertId;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getExpertId() {
    return expertId;
  }

  public void setExpertId(String expertId) {
    this.expertId = expertId;
  }



}
