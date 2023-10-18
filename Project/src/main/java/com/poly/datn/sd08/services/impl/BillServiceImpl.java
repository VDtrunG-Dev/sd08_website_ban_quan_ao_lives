package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TBill;
import com.poly.datn.sd08.repositories.BillRepository;
import com.poly.datn.sd08.services.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillServiceImpl implements IBillService {

    @Autowired
    private BillRepository billRepository;
    @Override
    public List<TBill> getAllBill() {
        return billRepository.findAll();
    }
}
