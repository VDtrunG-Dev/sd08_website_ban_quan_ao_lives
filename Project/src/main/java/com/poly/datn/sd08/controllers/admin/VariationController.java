package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TVariation;
import com.poly.datn.sd08.services.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/variation/")
public class VariationController {

    @Autowired
    private VariationService variationService;

    @GetMapping("hien-thi")
    public String displayVariation(@RequestParam(defaultValue = "0", name = "page")Integer pageNum, Model model){
        List<TVariation> tVariations = variationService.getALl();
        model.addAttribute("listV", tVariations);
        Page<TVariation> tVariationPage = variationService.phanTrangVariation(pageNum, 1);
        model.addAttribute("listV", tVariationPage);
        return "variaton/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        variationService.delete(id);
        return "redirect:/variation/hien-thi";
    }
}
