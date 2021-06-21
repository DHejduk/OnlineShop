package com.onlineshop.project.service;

import com.onlineshop.project.model.dto.ItemDto;
import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.model.entity.User;
import com.onlineshop.project.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl {

    @Autowired
    private final ItemRepository itemRepository;

    public Item newItem(ItemDto itemDto,  User byEmail){
        Item item = new Item();
        item.setItemName(itemDto.getItemName());
        item.setPrice(new BigDecimal(itemDto.getPrice()));
        item.setDescription(itemDto.getDescription());
        item.setImgUrl(itemDto.getImgUrl());
        item.setUser(byEmail);
        item.setStatus("OK");

        return item;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }


    public Item findByItemId(Long id) {
        return itemRepository.findByItemId(id);
    }


    public Item findByItemName(String name) {
        return itemRepository.findByItemName(name);
    }


    public Item findLastAddedItem() {
        return itemRepository.findFirstByOrderByItemIdDesc();
    }


    public List<Item> findAllSellingItems() {
        return itemRepository.findAll();
    }


    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }


    public void updateItem(String id, ItemDto itemDto, User byEmail) {
        Item item = new Item();
        item.setItemId(Long.valueOf(id));
        item.setItemName(itemDto.getItemName());
        item.setPrice(new BigDecimal(itemDto.getPrice()));
        item.setDescription(itemDto.getDescription());
        item.setUser(byEmail);
        item.setStatus("OK");

        itemRepository.save(item);
    }


    public List<Item> findItemByUserId(Long id, String status) {
        return itemRepository.findItemsByUserId(id, status);
    }


    public List<Item> findItemWhereUserIdNotIn(Long id, String status) {
        return itemRepository.findItemsNotContainingUserId(id, status);
    }



}
