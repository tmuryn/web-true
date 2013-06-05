package org.webtrue.core.service;

import java.util.Collection;

import org.webtrue.core.model.Authorship;

public interface AuthorshipService extends CommonModelCRUD<Authorship> {
	public Collection<Authorship> getByAuthor(String authorEmail);
}
