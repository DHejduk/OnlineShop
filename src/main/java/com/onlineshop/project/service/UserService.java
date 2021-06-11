package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.User;

import java.util.List;

public interface UserService   {
    void save(User user);
    User  findById(Long id);
    User findByEmail(String username);
    User findByUserNameAndPassword(String username, String password);
    String encodePassword(String password);


}
