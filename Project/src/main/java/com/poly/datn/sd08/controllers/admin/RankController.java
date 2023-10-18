package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TRank;
import com.poly.datn.sd08.services.impl.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/rank/")
public class RankController {

    @Autowired
    private RankServiceImpl rankService;


    @GetMapping("view")
    public String hienThi(Model model) {
        List<TRank> listRank = rankService.getAll();
        model.addAttribute("listRank", listRank);
        return "admin/rank/view";
    }
}
