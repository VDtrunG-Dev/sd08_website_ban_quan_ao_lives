package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TBill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillRepository extends JpaRepository<TBill, Long> {
}
