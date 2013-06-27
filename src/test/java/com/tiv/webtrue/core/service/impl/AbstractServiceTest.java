package com.tiv.webtrue.core.service.impl;



import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tiv.webtrue.core.dao.dto.AccountDTO;
import com.tiv.webtrue.core.dao.dto.BaseDTO;
import com.tiv.webtrue.core.service.AbstractService;

public abstract class AbstractServiceTest<T extends BaseDTO>
    extends AbstractJUnit4SpringContextTests {

  public AbstractServiceTest() {
    super();
  }

  @Test
  public void testManage() {
    try {
      getService().get(7L);
      fail("Must be exception");
    } catch (ObjectNotFoundException exception) {
      Assert.assertEquals(exception.getEntityName(), AccountDTO.class.getName());
    }

    T account = createModel();
    getService().save(account);

    T account2 = getService().get(account.getId());
    Assert.assertNotNull(account2);

    getService().delete(account.getId());
  }

  protected abstract T createModel();

  protected abstract AbstractService<T> getService();

  @Test
  public void testGetOrder() {
    List<T> list = new ArrayList<T>();
    for (int i = 0; i < 5; i++) {
      T createModel = createModel();
      getService().save(createModel);
      list.add(createModel);
    }

    Collection<T> collection = getService().get(1, 2, Order.asc("id"));
    Assert.assertEquals(2, collection.size());
    Long id = Long.MIN_VALUE;
    for (T t : collection) {
      Assert.assertTrue(t.getId().compareTo(id) > 0);
      id = t.getId();
    }


    collection = getService().get(1, 2, Order.desc("id"));
    Assert.assertEquals(2, collection.size());
    id = Long.MAX_VALUE;
    for (T t : collection) {
      Assert.assertTrue(t.getId().compareTo(id) < 0);
      id = t.getId();
    }
  }

}
