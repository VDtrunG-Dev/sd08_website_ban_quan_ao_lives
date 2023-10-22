package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOptionRepository extends JpaRepository<TOption, Long> {
    TOption findById(int id);
}
