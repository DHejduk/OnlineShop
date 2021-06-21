package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.Role;
import com.onlineshop.project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl  {

    @Autowired
    private final RoleRepository repository;

    public Role findRoleByName(String name) {
        return repository.findByName(name);
    }
}
