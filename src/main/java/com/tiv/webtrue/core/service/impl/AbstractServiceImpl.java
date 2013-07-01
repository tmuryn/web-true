package com.tiv.webtrue.core.service.impl;

import java.util.Collection;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.dto.BaseDTO;
import com.tiv.webtrue.core.service.AbstractService;

@Service
@Transactional
public abstract class AbstractServiceImpl<T extends BaseDTO> implements AbstractService<T> {

  @Override
  public T get(Long id) {
    return getDao().find(id);
  }

  @Override
  public Collection<T> get(int page, int itemOnPage, Order order) {
    int firstResult = page==1 ? 0 : (page-1)*itemOnPage;
    return getDao().find(order, firstResult, itemOnPage);
  }

  @Override
  public void save(T model) {
    getDao().save(model);
  }

  @Override
  public void delete(Long id) {
    getDao().delete(id);
  }

  abstract AbstractDao<T, Long> getDao();


}
