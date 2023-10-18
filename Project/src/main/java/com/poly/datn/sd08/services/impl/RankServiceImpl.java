package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TRank;
import com.poly.datn.sd08.repositories.RankRepository;
import com.poly.datn.sd08.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl  implements RankService {

    @Autowired
    private RankRepository rankRepository;

    @Override
    public List<TRank> getAll() {
        return rankRepository.findAll();
    }

    @Override
    public List<TRank> getExcel() {
        return rankRepository.findAll();
    }
}
