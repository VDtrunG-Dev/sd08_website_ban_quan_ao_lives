package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository extends JpaRepository<TSupplier, Long> {
}
