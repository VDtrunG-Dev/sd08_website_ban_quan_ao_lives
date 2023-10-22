package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TOption;

import java.util.List;

public interface IOptionService {
    List<TOption> getAllOption();
    TOption add(TOption option);
    void update(TOption category);
    void delete(Long id);
}
