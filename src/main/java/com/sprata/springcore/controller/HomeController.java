package com.sprata.springcore.controller;

import com.sprata.springcore.model.UserRoleEnum;
import com.sprata.springcore.security.UserDetailsImpl;
import lombok.ToString;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/") //login된 사용자의 정보를 가져온다. @ AuthenticationPrincipal
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if(userDetails.getUser().getRole() == UserRoleEnum.ADMIN){
            model.addAttribute("admin_role", true);
        }

        return "index";
    }
}
