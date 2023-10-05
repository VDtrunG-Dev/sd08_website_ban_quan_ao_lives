package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TVariation;
import com.poly.datn.sd08.services.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/variation/")
@Controller
public class VariationController {

    @Autowired
    private VariationService variationService;

    @GetMapping("view")
    public String hienThi(Model model) {
        List<TVariation> list = variationService.getALl();
        model.addAttribute("list", list);
        return "admin/variation/index";
    }

    @PostMapping("add")
    public String add(TVariation variation) {
        variationService.save(variation);
        return "redirect:/variation/view";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        TVariation variation = variationService.findById(id);
        model.addAttribute("variation", variation);
        return "admin/variation/edit";
    }

    @PostMapping("update")
    public String update(TVariation variation) {
        variationService.save(variation);
        return "redirect:/variation/view";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        variationService.delete(id);
        return "redirect:/variation/hien-thi";
    }


}
