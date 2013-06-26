package com.tiv.webtrue.core.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.core.dao.AbstractDao;

@Transactional
public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E, I> {

  private Class<E> entityClass;

  protected AbstractDaoImpl(Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  @Autowired
  private SessionFactory sessionFactory;

  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }


  public E find(I id) {
    E e = (E) getCurrentSession().get(entityClass, id);
    if (e == null) {
      throw new ObjectNotFoundException(id, entityClass.getName());
    }
    return e;
  }


  public void save(E e) {
    getCurrentSession().saveOrUpdate(e);
  }


  public void delete(I e) {
    Object object = find(e);
    getCurrentSession().delete(object);
  }


  public List<E> find(Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    return criteria.list();
  }
  
  public List<E> find(Criterion criterion,Order order,int firstResult,int maximumResults) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.addOrder(order);
    criteria.setMaxResults(maximumResults);
    criteria.setFirstResult(firstResult);
    return criteria.list();
  }
  
  public List<E> find(Order order,int firstResult,int maximumResults) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.addOrder(order);
    criteria.setMaxResults(maximumResults);
    criteria.setFirstResult(firstResult);
    return criteria.list();
  }

  public List<E> getAll() {
    return getCurrentSession().createCriteria(entityClass).list();
  }

  public E findFirst(Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    return (E) (criteria.list().isEmpty() ? null : criteria.list().get(0));
  }
}
