package com.onlineshop.project.repository;

import com.onlineshop.project.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
    
    User findByUserNameAndPassword(String username, String password);
}
