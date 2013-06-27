package com.tiv.webtrue.core.dao.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Article")
public class ArticleDTO extends BaseDTO {
  
  private String title;
  private String content;
  private String expertId;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

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
