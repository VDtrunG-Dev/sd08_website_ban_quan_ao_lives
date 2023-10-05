package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TVariation;
import com.poly.datn.sd08.services.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/variation/")
@Controller
public class VariationController {

    @Autowired
    private VariationService variationService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        List<TVariation> list = variationService.getALl();
        model.addAttribute("list", list);
        return "admin/variation/index";
    }
}
