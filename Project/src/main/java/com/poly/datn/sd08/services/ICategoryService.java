package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TCategory;

import java.util.List;

public interface ICategoryService {
    List<TCategory> getAllCategory();
    TCategory add(TCategory category);
    void update(TCategory category);
    void delete(Long id);
    TCategory findById(int id);
}
