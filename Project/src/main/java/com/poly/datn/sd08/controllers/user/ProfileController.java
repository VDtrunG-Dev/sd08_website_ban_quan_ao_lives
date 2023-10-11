package com.poly.datn.sd08.controllers.user;

import com.poly.datn.sd08.model.dto.ResetPasswordProfileDTO;
import com.poly.datn.sd08.model.entities.TAddress;
import com.poly.datn.sd08.model.entities.TUser;
import com.poly.datn.sd08.services.impl.AddRessServices;
import com.poly.datn.sd08.services.impl.ProfileServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private AddRessServices addRessServices;

    @Autowired
    private ProfileServicesImpl profileServices;

    @GetMapping("")
    private String pageProfile(HttpSession session){
        TUser user = (TUser) session.getAttribute("account");
        TAddress address = new TAddress();
        return "user/profile/profile";
    }

    @PostMapping("/update")
    private String updateProfile(Model model, HttpSession session,
                                     @ModelAttribute("infomationUser") TUser user){
        TUser userSession = (TUser) session.getAttribute("account");
        TUser userUpadte = profileServices.updateProfileUser(userSession,user);
        return "user/profile/profile";
    }

    @PostMapping("/resetpassword")
    private String pageResetPassword(Model model, HttpSession session,
                                     @ModelAttribute("password") ResetPasswordProfileDTO resetPassword){
        TUser userSession = (TUser) session.getAttribute("account");
        TUser checkPassword = profileServices.resetPassword(userSession,resetPassword);

        return "user/profile/profile";
    }
}
