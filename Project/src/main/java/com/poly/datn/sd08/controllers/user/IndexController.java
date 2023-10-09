package com.poly.datn.sd08.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/home")
    private String pageIndex(){
        return "user/home/home";
    }


}
