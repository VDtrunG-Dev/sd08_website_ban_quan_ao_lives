package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TRank;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RankService {

    List<TRank> getAll();

    List<TRank> getExcel();


    TRank getById(Long id);


    void save(TRank rank);


    void update(Long id, TRank rank);

    void deleteById(Long id);

    Page<TRank> phanTrang(Integer page, Integer size);
}
