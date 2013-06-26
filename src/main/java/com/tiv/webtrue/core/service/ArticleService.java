package com.tiv.webtrue.core.service;

import java.util.Collection;

import com.tiv.webtrue.core.model.Account;
import com.tiv.webtrue.core.model.Article;

public interface ArticleService extends AbstractService<Article> {
	public Collection<Article> getByAuthor(Account account);
}
