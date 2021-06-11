package com.onlineshop.project.repository;

import com.onlineshop.project.model.entity.Transaction;
import com.onlineshop.project.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByBuyer(User user);
    List<Transaction> findAllByVendor(User user);

}
