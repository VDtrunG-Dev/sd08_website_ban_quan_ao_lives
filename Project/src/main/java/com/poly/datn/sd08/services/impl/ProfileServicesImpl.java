package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.dto.ResetPasswordProfileDTO;
import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServicesImpl {

    @Autowired
    private IUserRepository userRepository;

    public TUser resetPassword(TUser user, ResetPasswordProfileDTO passwordNew){
        if (user.getPassword().equals(passwordNew.getPassword())){
            user.setPassword(passwordNew.getNewPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public TUser updateProfileUser(TUser user,TUser userNew){
        user.setEmail(userNew.getEmail());
        user.setFirstName(userNew.getFirstName());
        user.setLastName(userNew.getLastName());
        user.setPhoneNumber(userNew.getPhoneNumber());

        TUser userUpdate = userRepository.save(user);
        return userUpdate;
    }


}
