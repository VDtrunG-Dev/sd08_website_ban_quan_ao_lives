package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TRole;
import com.poly.datn.sd08.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServicesImpl {

    @Autowired
    private IRoleRepository roleRepository;

    public TRole findByRoleCode(String roleCode){
        return roleRepository.findByRoleCode(roleCode);
    }
}
