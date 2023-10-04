package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<TProduct, Long> {
}
