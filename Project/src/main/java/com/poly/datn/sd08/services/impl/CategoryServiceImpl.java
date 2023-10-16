package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TCategory;
import com.poly.datn.sd08.repositories.ICategoryRepository;
import com.poly.datn.sd08.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<TCategory> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public TCategory add(TCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public void update(TCategory category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public TCategory findById(int id) {
        return categoryRepository.findById(id);
    }


}
