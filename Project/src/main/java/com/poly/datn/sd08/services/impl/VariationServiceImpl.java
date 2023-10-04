package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TVariation;
import com.poly.datn.sd08.repositories.VariationRepository;
import com.poly.datn.sd08.services.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariationServiceImpl implements VariationService {

    @Autowired
    private VariationRepository variationRepository;

    @Override
    public List<TVariation> getALl() {
        return variationRepository.findAll();
    }

    @Override
    public void add(TVariation tVariation) {
        variationRepository.save(tVariation);
    }

    @Override
    public TVariation detail(Long id) {
        return variationRepository.getTVariationById(id);
    }

    @Override
    public void delete(Long id) {
            variationRepository.deleteById(id);
    }

    @Override
    public Page<TVariation> phanTrangVariation(Integer pageNum, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNum, pageNo);
        return  variationRepository.findAll(pageable);
    }
}
