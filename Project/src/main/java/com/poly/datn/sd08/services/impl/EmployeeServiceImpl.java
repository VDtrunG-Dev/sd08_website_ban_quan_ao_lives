package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.repositories.EmployeeRepository;
import com.poly.datn.sd08.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository userRepository;

    @Override
    public List<TUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public TUser findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TUser user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
