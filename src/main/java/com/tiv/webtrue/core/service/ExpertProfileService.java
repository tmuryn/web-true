package com.tiv.webtrue.core.service;

import java.util.Collection;

import com.tiv.webtrue.core.model.Profile;

public interface ExpertProfileService extends AbstractService<Profile> {
	public Collection<Profile> getByAuthor(String authorEmail);
}
