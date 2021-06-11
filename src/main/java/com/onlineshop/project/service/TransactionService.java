package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.Transaction;
import com.onlineshop.project.model.entity.User;

import java.util.List;

public interface TransactionService {
    List<Transaction> findSold(User user);
    List<Transaction> findBought(User user);
    void save(Transaction transaction);

}
