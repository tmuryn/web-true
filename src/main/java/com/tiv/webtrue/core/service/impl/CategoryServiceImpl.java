package com.tiv.webtrue.core.service.impl;

import com.tiv.webtrue.core.service.CategoryService;
import com.tiv.webtrue.core.service.bo.CategoryBO;
import com.tiv.webtrue.dao.CategoryDao;
import com.tiv.webtrue.dao.dto.CategoryDTO;

import org.dozer.Mapper;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static com.tiv.webtrue.core.utils.MapperUtils.map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDao dao;

  @Autowired
  private Mapper mapper;

  @Override
  public List<CategoryBO> getAll() {
    return map(mapper, dao.getAll(), CategoryBO.class);
  }

  @Override
  public CategoryDTO get(Long id) {
    return null;
  }

  @Override
  public void save(CategoryDTO model) {
  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public Collection<CategoryDTO> get(int page, int itemOnPage, Order order) {
    return null;
  }
}
