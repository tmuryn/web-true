package com.tiv.webtrue.core.dao.dto;

public class ArticleDTO extends BaseModelDTO {
  
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
