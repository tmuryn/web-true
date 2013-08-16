package com.tiv.webtrue.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.ArticleDao;
import com.tiv.webtrue.dao.dto.ArticleDTO;

@Service

public class ArticleServiceImpl extends AbstractServiceImpl<ArticleDTO> {

 @Autowired
 private ArticleDao articleDao;
  
  @Override
  AbstractDao<ArticleDTO, Long> getDao() {
    return articleDao;
  }
  
  

}
