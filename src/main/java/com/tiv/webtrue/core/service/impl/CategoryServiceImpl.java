package com.tiv.webtrue.core.service.impl;

import com.tiv.webtrue.dao.dto.CategoryDTO;
import com.tiv.webtrue.web.model.CategoryModel;
import com.tiv.webtrue.core.service.CategoryService;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Override
  public CategoryDTO get(Long id) {
    return null;
  }

  @Override
  public void save(CategoryDTO categoryDTO) {
  }

  public void saveModel(CategoryModel categoryModel) {

  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public Collection<CategoryDTO> get(int page, int itemOnPage, Order order) {
    return null;
  }

  public Collection<CategoryModel> getModels(int page, int itemOnPage, Order order) {
    return null;
  }

  @Override
  public Collection<CategoryDTO> getAllDtos() {
    return null;
  }

  @Override
  public Collection<CategoryModel> getAllModels() {
    return null;
  }
}
