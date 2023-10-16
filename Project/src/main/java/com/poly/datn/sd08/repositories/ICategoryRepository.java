package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<TCategory, Long> {
   TCategory findById(int id);

}
