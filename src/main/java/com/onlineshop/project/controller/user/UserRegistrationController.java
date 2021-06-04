package com.onlineshop.project.controller.user;


import com.onlineshop.project.model.dto.UserRegistrationDto;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class UserRegistrationController{

    @Autowired
    private final UserServiceImpl userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/sign-up")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userSignUp", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/sign-up")
    public String register(@ModelAttribute("userSignUp")UserRegistrationDto userRegistrationDto){
        User user = new User();
        user.setUserName(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        userService.save(user);
    return "redirect:/login";
    }


}
