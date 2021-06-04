package com.onlineshop.project.service;

import com.onlineshop.project.model.dto.UserLoginDto;
import com.onlineshop.project.model.entity.User;

public interface UserService   {
    void save(User user);
    User findByEmail(String username);
    User findByUserNameAndPassword(String username, String password);
    String encodePassword(String password);
}
