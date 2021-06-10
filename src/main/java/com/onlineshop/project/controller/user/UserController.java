package com.onlineshop.project.controller.user;


import com.onlineshop.project.model.dto.UserLoginDto;
import com.onlineshop.project.service.impl.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequiredArgsConstructor
public class UserController {


    private final MyUserDetailsService userDetailsService;



}
