package com.poly.datn.sd08.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/home/cart")
    private String pageIndex(){
        return "user/cart/cart";
    }
}
