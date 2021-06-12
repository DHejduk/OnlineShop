package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.model.entity.Transaction;
import com.onlineshop.project.service.impl.ItemServiceImpl;
import com.onlineshop.project.service.impl.TransactionServiceImpl;
import com.onlineshop.project.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller @AllArgsConstructor
public class TransactionController {
    @Autowired
    private final ItemServiceImpl itemService;
    @Autowired
    private final UserServiceImpl userService;
    @Autowired
    private final TransactionServiceImpl transactionService;

    @GetMapping("/shop/item/checkout/{id}")
    public String checkout(@PathVariable("id") String id, Model model){
        Item byItemId = itemService.findByItemId(Long.valueOf(id));
        model.addAttribute("item", byItemId);
        return "checkout";
    }

    @PostMapping("/shop/item/buy/{id}")
    public String buyItem(@PathVariable("id") String id){
        Item byItemId = itemService.findByItemId(Long.valueOf(id));
        byItemId.setStatus("SOLD");
        Transaction transaction = new Transaction();
        transaction.setItem(byItemId);
        transaction.setBuyer(userService.getUser());
        transaction.setVendor(byItemId.getUser());
        transactionService.save(transaction);
        return "redirect:/shop";
    }

    @GetMapping("/shop/bought")
    public String showBoughtItems(Model model){
        List<Transaction> bought = transactionService.findBought(userService.getUser());
        model.addAttribute("bought", bought);
        return "bought";
    }

    @GetMapping("/shop/sold")
    public String showSoldItems(Model model){
        List<Transaction> sold = transactionService.findSold(userService.getUser());
        model.addAttribute("sold", sold);
        return "sold";
    }
}
