package com.poly.datn.sd08.controllers.admin;


import com.poly.datn.sd08.model.entities.TSupplier;
import com.poly.datn.sd08.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/supplier/")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        List<TSupplier> listS = supplierService.getAll();
        model.addAttribute("listS", listS);
        return "admin/supplier/index";
    }

   
}
