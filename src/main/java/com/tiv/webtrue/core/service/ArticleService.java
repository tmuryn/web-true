package com.tiv.webtrue.core.service;

import java.util.Collection;

import org.hibernate.criterion.Order;

import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.ArticleDTO;

public interface ArticleService extends AbstractService<ArticleDTO> {
  
	public Collection<ArticleDTO> getArticles(ArticleSearchQuery q);
}
