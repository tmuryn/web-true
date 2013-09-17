package com.tiv.webtrue.core.service.impl;

import java.util.Collection;
import java.util.Collections;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiv.webtrue.core.service.ArticleSearchQuery;
import com.tiv.webtrue.core.service.ArticleSearchQuery.Type;
import com.tiv.webtrue.core.service.ArticleService;
import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.ArticleDao;
import com.tiv.webtrue.dao.dto.ArticleDTO;

@Service
public class ArticleServiceImpl extends AbstractServiceImpl<ArticleDTO> implements ArticleService {

  @Autowired
  private ArticleDao articleDao;

  @Override
  AbstractDao<ArticleDTO, Long> getDao() {
    return articleDao;
  }

  @Override
  public Collection<ArticleDTO> getArticles(ArticleSearchQuery q) {
    Collection<ArticleDTO> collection = Collections.emptyList();
    Type type = q.getType();
    
    switch (type) {
      case Author:
        SimpleExpression criteria = Restrictions.eq("accountId", q.getAccountId());
        collection = articleDao.find(criteria,q.getType().getOrder(), q.getFirstResult(), q.getMaximumResults());
        break;

      default:
        criteria = Restrictions.eq("published", true);
        collection = articleDao.find(criteria,q.getType().getOrder(), q.getFirstResult(), q.getMaximumResults());
        break;
    }
    
    return collection;
  }

}
