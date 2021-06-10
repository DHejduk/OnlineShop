package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.service.impl.ItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class ShopController {
    @Autowired
    private final ItemServiceImpl itemService;

    @GetMapping("/shop")
    public String showShop(Model model) {
        List<Item> products = itemService.findAllSellingItems();
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String showItem( Model model, @PathVariable String id) {
        Item product = itemService.findByItemId(Long.valueOf(id));
        model.addAttribute("product",product);
        return "viewProduct";
    }




}
