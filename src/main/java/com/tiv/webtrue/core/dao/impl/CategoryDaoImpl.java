package com.tiv.webtrue.core.dao.impl;

import com.tiv.webtrue.core.dao.CategoryDao;
import com.tiv.webtrue.core.dao.dto.CategoryDTO;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends AbstractDaoImpl<CategoryDTO,Long> implements CategoryDao{

  protected CategoryDaoImpl() {
    super(CategoryDTO.class);
  }
}
