package com.onlineshop.project.controller.user;


import com.onlineshop.project.model.dto.UserRegistrationDto;
import com.onlineshop.project.model.entity.Role;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.service.PasswordEncoder;
import com.onlineshop.project.service.RoleServiceImpl;
import com.onlineshop.project.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequiredArgsConstructor
public class UserRegistrationController {

    @Autowired
    private final UserServiceImpl userService;

    @Autowired
    private final RoleServiceImpl roleService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/sign-up")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userSignUp", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/sign-up")
    public String processRegistrationForm(@ModelAttribute("userSignUp") @Valid UserRegistrationDto userRegistrationDto) {
        User user = new User();
        User byEmail = userService.findByEmail(userRegistrationDto.getEmail());

        if (byEmail != null) {
            return "redirect:/sign-up?error";
        }

        user.setUserName(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encoder().encode(userRegistrationDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findRoleByName("USER"));
        user.setRoles(roles);
        userService.save(user);

        return "redirect:/login";
    }


}
