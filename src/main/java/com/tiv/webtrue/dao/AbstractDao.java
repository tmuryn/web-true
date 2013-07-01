package com.tiv.webtrue.dao;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<E, I extends Serializable> {

    E find(I id);
    void save(E e);
    void delete(I e);
    List<E> getAll();
    List<E> find(Criterion criterion);
    List<E> find(Criterion criterion,Order order,int firstResult,int maximumResults);
    List<E> find(Order order,int firstResult,int maximumResults);
    E findFirst(Criterion criterion);
}
