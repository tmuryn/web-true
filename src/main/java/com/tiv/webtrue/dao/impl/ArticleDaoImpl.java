package com.tiv.webtrue.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.dao.ArticleDao;
import com.tiv.webtrue.dao.dto.ArticleDTO;

@Repository
public class ArticleDaoImpl extends AbstractDaoImpl<ArticleDTO, Long> implements ArticleDao{

  protected ArticleDaoImpl() {
    super(ArticleDTO.class);
  }
  
  
  
  
}
