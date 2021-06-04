package com.onlineshop.project.service.impl;

import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.repository.RoleRepository;
import com.onlineshop.project.repository.UserRepository;
import com.onlineshop.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final RoleRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

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
        return passwordEncoder.encode(password);
    }

    public boolean isCorrect(String encodedPassword, String rawPassword){
        return passwordEncoder.matches(rawPassword,encodedPassword);
    }
}
