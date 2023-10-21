package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TRank;
import com.poly.datn.sd08.model.entities.TVoucher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VoucherService {

    List<TVoucher> getAll();

    List<TVoucher> getExcel();

    void add(TVoucher voucher);

    void deleteById(Long id);

    Page<TVoucher> phanTrang(Integer page, Integer size);

}
