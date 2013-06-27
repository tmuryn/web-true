package com.tiv.webtrue.core.service;

import java.util.Collection;

import org.hibernate.criterion.Order;

import com.tiv.webtrue.core.dao.dto.BaseDTO;

public interface AbstractService<T extends BaseDTO> {

  public T get(Long id);

  public void save(T model);

  public void delete(Long id);

  Collection<T> get(int page, int itemOnPage, Order order);


}
