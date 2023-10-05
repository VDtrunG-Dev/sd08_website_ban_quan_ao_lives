package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.repositories.IUserRepository;
import com.poly.datn.sd08.services.impl.UserServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@Controller
public class LoginController {
    private final JavaMailSender emailSender ;
    private static String emails;

    public LoginController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Autowired
    private UserServicesImpl userServices;

    @Autowired
    private IUserRepository userRepository;



    @GetMapping("/login")
    private String pageLogin(Model model){
        model.addAttribute("isDisplayLogin", true);
        model.addAttribute("isDisplayRegister", false);
        return "login";
    }

    @PostMapping("/signin")
    private String loginPost(Model model, @ModelAttribute("account") TUser userInput, HttpSession session){
        TUser user = userRepository.findByEmail(userInput.getEmail());
        if(user != null ){
            TUser userFind = userServices.findByEmailAndSdt(user);
            System.out.println(user.getRole().getRoleCode());
            System.out.println(userFind.getStatus());
            if(userFind.getStatus() == 1 && userFind.getRole().getRoleCode().equals("user")){
                session.setAttribute("account",user);
                return "redirect:/login/forgotpassword";
            }else {
                session.setAttribute("account",user);
                return "redirect:/admin/brand/view";
            }

        }else {
            model.addAttribute("error","Thông tin không tồn tại");
        }
        return "login";
    }


    @GetMapping("/forgotpassword")
    private String pageForgotPassword(Model model){
        model.addAttribute("isDisplayInputEmail",true);
        return "forgotpassword";
    }

    @GetMapping("register")
    private String pageRegister(Model model){
        model.addAttribute("isDisplayLogin", false);
        model.addAttribute("isDisplayRegister", true);
        return "login";
    }
    @PostMapping("/register")
    private String pageSignUp(Model model,@ModelAttribute("signup") TUser user){

//        if(userServices.addUser(user)){
//            System.out.println("Lưu thành công");
//        }else {
//            System.out.println("Lưu thất bại");
//        }
//        model.addAttribute("isDisplayLogin", false);
//        model.addAttribute("isDisplayRegister", true);
        return "login";
    }

    @PostMapping("/send-email")
    private String sendEmail(@RequestParam("toEmail") String email){
        String to = email;
        System.out.println(email);
        String subject = "Đổi Mật Khẩu Tài Khoản";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        return "login";
    }
}
