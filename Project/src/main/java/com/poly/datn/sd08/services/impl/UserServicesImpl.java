package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TRole;
import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.repositories.IRoleRepository;
import com.poly.datn.sd08.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public List<TUser> findAll(){
        return userRepository.findAll();
    }

    public TUser findByEmailAndSdt(TUser user){

        if(user != null && user.getPassword().equals(user.getPassword()) && user.getEmail().equals(user.getEmail())){
            return user;
        }
        return null;
    }

    public boolean addUser(TUser user){
        try {

            TRole role = roleRepository.findByRoleCode("user");
            user.setRole(role);
            user.setStatus(1);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}