package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TSupplier;

import java.util.List;

public interface SupplierService {

    List<TSupplier> getAll();

    TSupplier findById(Long id);

    void save(TSupplier supplier);

    void delete(Long id);
}
