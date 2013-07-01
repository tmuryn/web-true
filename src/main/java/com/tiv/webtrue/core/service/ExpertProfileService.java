package com.tiv.webtrue.core.service;

import java.util.Collection;

import com.tiv.webtrue.dao.dto.ProfileDTO;

public interface ExpertProfileService extends AbstractService<ProfileDTO> {
	public Collection<ProfileDTO> getByAuthor(String authorEmail);
}
