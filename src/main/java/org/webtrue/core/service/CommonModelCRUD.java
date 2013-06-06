package org.webtrue.core.service;

import java.util.Collection;

import org.webtrue.core.model.CommonModel;

public interface CommonModelCRUD<T extends CommonModel> {
	public T getById(Long id);

	public T getByUid(String uid);

	public Collection<T> getAll();

	public void create(T model);

	public void update(T model);

	public void deleteById(Long id);

	public void deleteByUid(String uid);

}
