package com.tiv.webtrue.core.service;

import java.util.Collection;

import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.ArticleDTO;

public interface ArticleService extends AbstractService<ArticleDTO> {
	public Collection<ArticleDTO> getByAuthor(AccountDTO account);
}
