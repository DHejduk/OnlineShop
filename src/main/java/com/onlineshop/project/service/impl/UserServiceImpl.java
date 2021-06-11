package com.onlineshop.project.service.impl;

import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.repository.UserRepository;
import com.onlineshop.project.security.SecurityConfig;
import com.onlineshop.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }


    @Override
    public User findByUserNameAndPassword(String username, String password) {
        return userRepository.findByUserNameAndPassword(username,password);
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encoder().encode(password);
    }


    public boolean passwordMatches( String given,String encoded){
//        return securityConfig.bCryptPasswordEncoder().matches(given,encoded);
        return passwordEncoder.encoder().matches(given, encoded);
    }

    public User getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();        String username;
        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return  this.findByEmail(username);

    }

}
