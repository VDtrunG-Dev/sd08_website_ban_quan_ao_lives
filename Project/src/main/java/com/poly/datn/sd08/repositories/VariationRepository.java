package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TVariation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariationRepository  extends JpaRepository<TVariation, Long> {
}
