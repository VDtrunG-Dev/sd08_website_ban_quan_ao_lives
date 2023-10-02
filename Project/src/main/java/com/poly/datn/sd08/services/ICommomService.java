package com.poly.datn.sd08.services;

import java.util.List;

public interface ICommomService <T, K>{

    List<T> findAll();

    T findById (K id);

    T add(T t);

    T update(T t, K id);

    Boolean delete(K id);

    List<T> findByStatus(Integer status);
}
