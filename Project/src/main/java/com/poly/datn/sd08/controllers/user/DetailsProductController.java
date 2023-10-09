package com.poly.datn.sd08.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailsProductController {

    @GetMapping("/home/details")
    private String pageDetailProduct(Model model){
        return "user/detailProduct/detailProduct";
    }
}
