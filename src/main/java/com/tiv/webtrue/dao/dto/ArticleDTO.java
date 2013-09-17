package com.tiv.webtrue.dao.dto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "Article")
public class ArticleDTO extends BaseDTO {
  
  
  public static String CREATION_DATE = "creationDate";
  public static String VIEWS_COUNT = "viewsCount";
  public static String COMMENTS_COUNT = "commentsCount";
  public static String LIKES_COUNT = "likesCount";
  public static String DISLIKE_COUNT = "dislikeCount";

  private String title;
  private Long accountId;
  private Long viewsCount;
  private Long commentsCount;
  private Long likesCount;
  private Long dislikeCount;
  private String text;
  private Date creationDate;
  private Date updateDate;
  private boolean published;

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  @Lob
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

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

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Long getViewsCount() {
    return viewsCount;
  }

  public void setViewsCount(Long viewsCount) {
    this.viewsCount = viewsCount;
  }

  public Long getCommentsCount() {
    return commentsCount;
  }

  public void setCommentsCount(Long commentsCount) {
    this.commentsCount = commentsCount;
  }

  public Long getLikesCount() {
    return likesCount;
  }

  public void setLikesCount(Long likesCount) {
    this.likesCount = likesCount;
  }

  public Long getDislikeCount() {
    return dislikeCount;
  }

  public void setDislikeCount(Long dislikeCount) {
    this.dislikeCount = dislikeCount;
  }



}
