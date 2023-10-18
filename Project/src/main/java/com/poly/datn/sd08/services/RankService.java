package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TRank;

import java.util.List;

public interface RankService {

    List<TRank> getAll();

    List<TRank> getExcel();
}
