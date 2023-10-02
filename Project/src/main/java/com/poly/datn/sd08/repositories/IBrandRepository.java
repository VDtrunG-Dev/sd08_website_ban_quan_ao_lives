package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBrandRepository extends JpaRepository<TBrand, Long> {
    List<TBrand> findByStatus(Integer status);
}
