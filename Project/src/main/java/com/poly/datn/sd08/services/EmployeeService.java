package com.poly.datn.sd08.services;

import com.poly.datn.sd08.model.entities.TUser;

import java.util.List;

public interface EmployeeService {

    List<TUser> getAll();

    TUser findById(Long id);

    void save(TUser user);

    void delete(Long id);
}
