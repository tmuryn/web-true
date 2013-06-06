package org.webtrue.core.service;

import java.util.Collection;

import org.webtrue.core.model.Account;
import org.webtrue.core.model.Article;

public interface ArticleService extends CommonModelCRUD<Article> {
	public Collection<Article> getByAuthor(Account account);
}
