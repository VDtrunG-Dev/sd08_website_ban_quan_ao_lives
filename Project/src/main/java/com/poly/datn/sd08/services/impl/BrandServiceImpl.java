package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TBrand;
import com.poly.datn.sd08.repositories.IBrandRepository;
import com.poly.datn.sd08.services.ICommomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements ICommomService<TBrand, Long> {

    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public List<TBrand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public TBrand findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public TBrand add(TBrand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public TBrand update(TBrand brand, Long id) {
        if(id != null){
            TBrand brandUpdate = brandRepository.findById(id).orElse(null);
            if(brandUpdate!=null){
                BeanUtils.copyProperties(brand, brandUpdate);
                return brandRepository.save(brandUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if(id != null){
            TBrand brandDelete = brandRepository.findById(id).orElse(null);
            brandRepository.delete(brandDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<TBrand> findByStatus(Integer status) {
        return brandRepository.findByStatus(status);
    }
}
