package com.poly.datn.sd08.controllers.admin;


import com.poly.datn.sd08.model.entities.TSupplier;
import com.poly.datn.sd08.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/supplier/")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("view")
    public String hienThi(Model model) {
        List<TSupplier> listS = supplierService.getAll();
        model.addAttribute("listS", listS);
        return "admin/supplier/index";
    }

    @PostMapping("add")
    public String add(TSupplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier/view";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        TSupplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "admin/supplier/edit";
    }

    @PostMapping("update")
    public String capNhat(TSupplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier/view";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        supplierService.delete(id);
        return "redirect:/supplier/view";
    }

}
