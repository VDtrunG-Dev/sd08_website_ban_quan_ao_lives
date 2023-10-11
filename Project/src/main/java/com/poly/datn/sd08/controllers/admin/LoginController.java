package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.services.impl.UserServicesImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class LoginController {
    private final JavaMailSender emailSender ;
    private static String emails;

    public LoginController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Autowired
    private UserServicesImpl userServices;

    @GetMapping("/login")
    private String pageLogin(Model model){
        model.addAttribute("isDisplayLogin", true);
        return "login";
    }

    @PostMapping("/signin")
    private String loginPost(Model model, @ModelAttribute("account") TUser userInput, HttpSession session){
        TUser user = userServices.checkUser(userInput);
        if(user != null ){
            if(user.getStatus() == 1 && user.getRole().getRoleCode().equals("user")){
                session.setAttribute("account",user);
                return "redirect:/profile";
            }else {
                session.setAttribute("account",user);
                return "redirect:/admin/brand/view";
            }
        }else {
            model.addAttribute("isDisplayLogin", true);
            model.addAttribute("error","Thông tin không tồn tại");
            return "login";
        }
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

    @PostMapping("/forgotpassword/send-email")
    private String sendEmail(@RequestParam("email") String email,Model model,HttpServletRequest request){
        TUser user = userServices.findByEmail(email);
        if(user == null) {
            model.addAttribute("messager", "Email Không Tồn Tại");
            return "forward:/forgot-password";
        }else {
            String resetLink = UriComponentsBuilder.fromHttpUrl(getBaseUrl(request))
                    .path("/newpassword")
                    .queryParam("email", email)
                    .encode() // Mã hóa giá trị tham số
                    .toUriString();

            String to = email;
            String subject = "Đổi Mật Khẩu Tài Khoản";
            String body = "Nhấn Vào Để Đổi Mật Khẩu : " +	 resetLink;
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            emailSender.send(message);
        }

        return "redirect:https://mail.google.com/";
    }

    @GetMapping("/newpassword")
    private String pageNewPassWord(@RequestParam("email") String email,Model model){
        emails = email;
        model.addAttribute("isDisplayNewPassWord", true);
        return "forgotpassword";
    }

    @PostMapping("/newpassword/submit")
    private String pageSubmitPassWord(Model model,@RequestParam("passwordNew") String passwordNew, @RequestParam("confirmPassword") String confirmPassword){
        TUser user = userServices.findByEmail(emails);
        try {
            user.setPassword(passwordNew);
            userServices.addUser(user);
        }catch (Exception e){

        }
        System.out.println(userServices.checkPassword(passwordNew,confirmPassword));
        System.out.println(passwordNew);
        System.out.println(confirmPassword);
        return "redirect:/login";
    }
    private String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();
        return scheme + "://" + serverName + ":" + serverPort + contextPath;
    }
}
