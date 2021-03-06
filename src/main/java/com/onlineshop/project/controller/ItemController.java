package com.onlineshop.project.controller;

import com.onlineshop.project.model.dto.ItemDto;
import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.service.ItemServiceImpl;
import com.onlineshop.project.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemServiceImpl itemService;

    @Autowired
    private final UserServiceImpl userService;

    @GetMapping("/shop/add-product")
    public String addNewItem(Model model) {
        model.addAttribute("productDTO", new ItemDto());

        return "sellItemForm";
    }

    @PostMapping("/shop/add-product")
    public String processAddForm(@ModelAttribute("productDTO") ItemDto itemDto) {
        User userByEmail = userService.getUser();
        Item newItem = itemService.newItem(itemDto, userByEmail);
        itemService.save(newItem);

        return "redirect:/shop/view-my-items";
    }

    @GetMapping("/shop/view-my-items")
    public String showUserItems(Model model) {
        User byEmail = userService.getUser();
        List<Item> products = itemService.findItemByUserId(byEmail.getUserId(), "SOLD");
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/shop/item/update/{id}")
    public String showItemUpdateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("itemId", id);
        Item byItemId = itemService.findByItemId(Long.valueOf(id));
        model.addAttribute("itemDTO", byItemId);

        return "updateItem";
    }

    @PostMapping("/shop/item/update/{id}")
    public String updateItem(@PathVariable("id") String id,
                             @ModelAttribute("itemDTO") ItemDto itemDto) {
        User byEmail = userService.getUser();
        itemService.updateItem(id,itemDto,byEmail);

        return "redirect:/shop/view-my-items";
    }

    @GetMapping("/shop/item/delete/{id}")
    public String deleteItem(@PathVariable("id") String id){
        itemService.deleteItem(Long.valueOf(id));

        return "redirect:/shop/view-my-items";
    }
}
