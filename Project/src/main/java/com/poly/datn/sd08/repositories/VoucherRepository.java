package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<TVoucher, Long> {
}
