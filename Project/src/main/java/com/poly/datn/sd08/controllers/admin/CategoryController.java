package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TCategory;
import com.poly.datn.sd08.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category/")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("view")
    public String getAllCategory(Model model) {
        List<TCategory> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "admin/category/categoryView";
    }
    @PostMapping("add")
    public String add(TCategory category){
        categoryService.add(category);
        return "redirect:/category/view";
    }
    @PostMapping("delete")
    public String deleteCategory(@RequestParam("categoryId") Long categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/category/view";
    }
    @GetMapping("/update/{id}")
    public String showUpdateCategoryPage(@PathVariable int id, Model model) {
        TCategory category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("category") TCategory category) {
        categoryService.update(category);
        return "redirect:/category/view";
    }
}
