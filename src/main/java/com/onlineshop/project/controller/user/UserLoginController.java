package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.dto.UserLoginDto;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller @RequiredArgsConstructor
public class UserLoginController {

    @Autowired
    private final UserServiceImpl userService;


    @GetMapping("/login")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userLogin", new UserLoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String after(@ModelAttribute("userLogin")UserLoginDto userLoginDto){
        return "redirect:/";
    }

}
