package com.onlineshop.project.service.impl;

import com.onlineshop.project.model.entity.Transaction;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.repository.TransactionRepository;
import com.onlineshop.project.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private final TransactionRepository repository;


    @Override
    public List<Transaction> findSold(User user) {
        return repository.findAllByVendor(user);
    }

    @Override
    public List<Transaction> findBought(User user) {
        return repository.findAllByBuyer(user);
    }

    @Override
    public void save(Transaction transaction) {
        repository.save(transaction);
    }
}
