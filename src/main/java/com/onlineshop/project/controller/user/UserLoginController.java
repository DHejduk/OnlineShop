package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.dto.UserLoginDto;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.service.impl.MyUserDetailsService;
import com.onlineshop.project.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserLoginController {

    @Autowired
    private final UserServiceImpl userService;
    private final MyUserDetailsService userDetailsService;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userLogin", new UserLoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("userLogin") UserLoginDto userLoginDto, Model model) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginDto.getEmail());
        User userDetails = userService.findByEmail(userLoginDto.getEmail());
        if (userDetails == null){
            return "redirect:/login?error";
        }
        if (!userService.matches(userDetails.getPassword(), userLoginDto.getPassword())) {
            return "redirect:/login?error";
        }
        return "redirect:/shop";

    }

}