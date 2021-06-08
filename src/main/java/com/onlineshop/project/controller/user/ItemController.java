package com.onlineshop.project.controller.user;

import com.onlineshop.project.model.dto.ItemDto;
import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.service.impl.ItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller @AllArgsConstructor
public class ItemController {

    @Autowired
    private final ItemServiceImpl itemService;
    @GetMapping("/shop/add-product")
    public String addNewItem(Model model) {
        model.addAttribute("productDTO", new ItemDto());
        return "sellItemForm";
    }

    @PostMapping("/shop/add-product")
    public String processLogin(@ModelAttribute("productDTO") ItemDto itemDto, Model model) {
        Item item = new Item();
        item.setItemName(itemDto.getItemName());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        item.setImgUrl(itemDto.getImgUrl());
        itemService.save(item);
        return "redirect:/shop/view-product";

    }


    @GetMapping("/shop/view-product")
    public String showItem(Model model) {
        Item lastAddedItem = itemService.findLastAddedItem();
        System.out.println(lastAddedItem.toString());
        model.addAttribute("product",lastAddedItem);
        return "viewProduct";
    }

}
