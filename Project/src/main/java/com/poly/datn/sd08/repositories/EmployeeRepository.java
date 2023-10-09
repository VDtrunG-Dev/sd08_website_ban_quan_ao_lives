package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<TUser, Long> {


}
