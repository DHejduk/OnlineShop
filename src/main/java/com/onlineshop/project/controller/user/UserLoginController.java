package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.dto.UserLoginDto;
import com.onlineshop.project.service.MyUserDetailsService;
import com.onlineshop.project.service.UserServiceImpl;
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

    @Autowired
    private final MyUserDetailsService userDetailsService;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userLogin", new UserLoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("userLogin") UserLoginDto userLoginDto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginDto.getEmail());

        if (userDetails == null){
            return "redirect:/login?error";
        }
        if (!userService.passwordMatches(userLoginDto.getPassword(),userDetails.getPassword())) {
            return "redirect:/login?error";
        }

        return "redirect:/shop";
    }
}
