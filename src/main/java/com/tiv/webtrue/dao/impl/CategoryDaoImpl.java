package com.tiv.webtrue.dao.impl;

import com.tiv.webtrue.dao.CategoryDao;
import com.tiv.webtrue.dao.dto.CategoryDTO;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends AbstractDaoImpl<CategoryDTO,Long> implements CategoryDao{

  protected CategoryDaoImpl() {
    super(CategoryDTO.class);
  }
}
