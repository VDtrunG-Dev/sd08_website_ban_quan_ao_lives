package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TSupplier;
import com.poly.datn.sd08.repositories.SupplierRepository;
import com.poly.datn.sd08.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<TSupplier> getAll() {
        return supplierRepository.findAll();
    }




}
