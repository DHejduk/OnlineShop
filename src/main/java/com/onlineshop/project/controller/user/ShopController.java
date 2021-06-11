package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.service.impl.ItemServiceImpl;
import com.onlineshop.project.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    private final UserServiceImpl userService;

    @GetMapping("/shop")
    public String showShop(Model model) {Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User byEmail = userService.findByEmail(username);

        List<Item> products = itemService.findItemWhereUserIdNotIn(byEmail.getUserId());
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
