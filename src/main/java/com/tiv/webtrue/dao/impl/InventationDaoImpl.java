package com.tiv.webtrue.dao.impl;

import org.springframework.stereotype.Repository;

import com.tiv.webtrue.dao.InventationDao;
import com.tiv.webtrue.dao.dto.InventationDTO;

@Repository
public class InventationDaoImpl extends AbstractDaoImpl<InventationDTO, Long> implements InventationDao {

  protected InventationDaoImpl() {
    super(InventationDTO.class);
  }

}
