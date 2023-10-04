package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TProduct;
import com.poly.datn.sd08.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("hien-thi")
    public String displayProduct(Model model){
        List<TProduct> list = productService.getAll();
        model.addAttribute("listP", list);

        return "product/index";
    }
}
