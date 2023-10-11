package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TAddress;
import com.poly.datn.sd08.repositories.IAddRessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRessServices {

    @Autowired
    private IAddRessRepository addRessRepository;

    public TAddress addAddRess(TAddress address){
        return addRessRepository.save(address);
    }
}
