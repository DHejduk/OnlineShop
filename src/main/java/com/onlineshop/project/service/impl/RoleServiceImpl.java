package com.onlineshop.project.service.impl;

import com.onlineshop.project.model.entity.Role;
import com.onlineshop.project.repository.RoleRepository;
import com.onlineshop.project.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleRepository repository;

    @Override
    public Role findRoleByName(String name) {
        return repository.findByName(name);
    }
}
