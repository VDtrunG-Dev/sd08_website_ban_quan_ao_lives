package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TVariation;
import com.poly.datn.sd08.repositories.VariationRepository;
import com.poly.datn.sd08.services.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TVariation findById(Long id) {
        return variationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TVariation variation) {
        variationRepository.save(variation);
    }

    @Override
    public void delete(Long id) {
        variationRepository.deleteById(id);
    }


}
