package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TVariation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VariationService {

    List<TVariation> getALl();


    void add(TVariation tVariation);

    TVariation detail(Long id);

    void delete(Long id);

    Page<TVariation> phanTrangVariation(Integer pageNum, Integer pageNo);
}
