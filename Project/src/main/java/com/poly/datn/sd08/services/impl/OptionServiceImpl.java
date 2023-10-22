package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.model.entities.TOption;
import com.poly.datn.sd08.repositories.IOptionRepository;
import com.poly.datn.sd08.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OptionServiceImpl implements IOptionService {
    @Autowired
    private IOptionRepository optionRepository;


    @Override
    public List<TOption> getAllOption() {
        return optionRepository.findAll();
    }

    @Override
    public TOption add(TOption option) {
        return optionRepository.save(option);
    }

    @Override
    public void update(TOption option) {
        optionRepository.save(option);
    }
    public TOption findById(int id) {
        return optionRepository.findById(id);
    }


    @Override
    public void delete(Long id) {
        optionRepository.deleteById(id);
    }
}
