package com.poly.datn.sd08.services.impl;

import com.poly.datn.sd08.repositories.ProductRepository;
import com.poly.datn.sd08.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;
}
