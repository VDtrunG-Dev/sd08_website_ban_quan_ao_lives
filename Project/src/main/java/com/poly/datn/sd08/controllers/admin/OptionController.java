package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TOption;
import com.poly.datn.sd08.services.impl.OptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/option/")
public class OptionController {
    @Autowired
    private OptionServiceImpl optionService;
    @GetMapping("view")
    public String getAllCategory(Model model) {
        List<TOption> optionList = optionService.getAllOption();
        model.addAttribute("optionList", optionList);
        return "admin/option/optionView";
    }

    @PostMapping("delete")
    public String deleteCategory(@RequestParam("optionId") Long optionId) {
        optionService.delete(optionId);
        return "redirect:/option/view";
    }
    @PostMapping("add")
    public String add(TOption option){
        optionService.add(option);
        return "redirect:/option/view";
    }
    @GetMapping("/update/{id}")
    public String showUpdateOptionUpdate(@PathVariable int id, Model model) {
        TOption option = optionService.findById(id);
        model.addAttribute("option", option);
        return "admin/option/optionUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("option") TOption option) {
        optionService.update(option);
        return "redirect:/option/view";
    }
}
