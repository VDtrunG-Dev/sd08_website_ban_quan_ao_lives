package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddRessRepository extends JpaRepository<TAddress,Long> {
}
