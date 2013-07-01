package com.tiv.webtrue.core.service;

import com.tiv.webtrue.core.service.bo.CategoryBO;
import com.tiv.webtrue.dao.dto.CategoryDTO;

import java.util.List;

public interface CategoryService extends AbstractService<CategoryDTO> {

  List<CategoryBO> getAll();

}