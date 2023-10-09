package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<TRole,Long> {
    TRole findByRoleCode(String id);
}
