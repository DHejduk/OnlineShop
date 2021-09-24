package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.Transaction;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class TransactionServiceImpl  {

    @Autowired
    private final TransactionRepository repository;

    public List<Transaction> findSold(User user) {
        return repository.findAllByVendor(user);
    }

    public List<Transaction> findBought(User user) {
        return repository.findAllByBuyer(user);
    }

    public void save(Transaction transaction) {
        repository.save(transaction);
    }
}
