package com.poly.datn.sd08.controllers.admin;


import com.poly.datn.sd08.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier/")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
}
