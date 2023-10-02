package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TBrand;
import com.poly.datn.sd08.services.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    private BrandServiceImpl brandService;

    @GetMapping("/view")
    public String view(Model model){
        List<TBrand> brands = brandService.findAll();
        model.addAttribute("brands", brands);
        return "admin/index";
    }

}
