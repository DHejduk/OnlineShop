package com.onlineshop.project.repository;

import com.onlineshop.project.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findUserByUserId(Long id);

    User findByUserNameAndPassword(String username, String password);
}
