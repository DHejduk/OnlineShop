package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
@RequiredArgsConstructor
public class UserServiceImpl{

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void save(User user) {
        userRepository.save(user);
    }


    public User findById(Long id) {
        return userRepository.findUserByUserId(id);
    }

    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    public User findByUserNameAndPassword(String username, String password) {
        return userRepository.findByUserNameAndPassword(username,password);
    }

    public String encodePassword(String password) {
        return passwordEncoder.encoder().encode(password);
    }

    public boolean passwordMatches( String given,String encoded){
        return passwordEncoder.encoder().matches(given, encoded);
    }

    public User getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        return  this.findByEmail(username);
    }
}
