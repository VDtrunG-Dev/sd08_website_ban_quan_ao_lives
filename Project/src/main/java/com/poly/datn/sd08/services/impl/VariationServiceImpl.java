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


}
