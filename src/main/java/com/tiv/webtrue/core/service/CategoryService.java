package com.tiv.webtrue.core.service;

import com.tiv.webtrue.dao.dto.CategoryDTO;
import com.tiv.webtrue.web.model.CategoryModel;

import java.util.Collection;

public interface CategoryService extends AbstractService<CategoryDTO> {

  Collection<CategoryDTO> getAllDtos();
  Collection<CategoryModel> getAllModels();

}