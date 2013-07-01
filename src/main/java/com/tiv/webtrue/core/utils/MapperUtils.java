package com.tiv.webtrue.core.utils;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MapperUtils {

  public static <T, U> List<U> map(final Mapper mapper, final List<T> source, final Class<U> destinationType) {
    final List<U> result = new ArrayList<U>();
    for (T element : source) result.add(mapper.map(element, destinationType));
    return result;
  }
}