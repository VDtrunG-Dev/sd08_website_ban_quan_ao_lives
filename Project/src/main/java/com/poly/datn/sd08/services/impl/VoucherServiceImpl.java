package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TVoucher;
import com.poly.datn.sd08.repositories.VoucherRepository;
import com.poly.datn.sd08.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public List<TVoucher> getAll() {
        return voucherRepository.findAll();
    }

    @Override
    public List<TVoucher> getExcel() {
        return voucherRepository.findAll();
    }

    @Override
    public void add(TVoucher voucher) {
        voucherRepository.save(voucher);
    }

    @Override
    public void deleteById(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public Page<TVoucher> phanTrang(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return voucherRepository.findAll(pageable);
    }


}
