package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TBill;
import com.poly.datn.sd08.services.impl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bill/")
public class BillController {

    @Autowired
    private BillServiceImpl billService;

    @GetMapping("view")
    private String getAllBill(Model model){
        List<TBill> billList = billService.getAllBill();
        model.addAttribute("billList", billList);
        return "admin/bill/billView";

    }

}
