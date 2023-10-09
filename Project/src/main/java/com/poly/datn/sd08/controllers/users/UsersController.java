package com.poly.datn.sd08.controllers.users;


import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/employee/")
public class UsersController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("view")
    public String view(Model model) {

        model.addAttribute("contentPage", "admin/user/app-user-list.html");
        List<TUser> users = employeeService.getAll();
        model.addAttribute("users",users);
        return "/admin/user/app-user-list"; // Trả về tên của file HTML chứa bảng
    }

    @GetMapping("all")
    public ResponseEntity<List<TUser>> getAll() {
        List<TUser> users = employeeService.getAll();
        return ResponseEntity.ok(users);
    }

}
