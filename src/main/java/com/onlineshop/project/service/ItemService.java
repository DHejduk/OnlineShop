package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.Item;

import java.util.List;

public interface ItemService {
    void save(Item item);
    Item findByItemId(Long id);
    Item findByItemName(String name);
    Item findLastAddedItem();
    List<Item> findAllSellingItems();
    void deleteItem(Long id);
    void updateItem(Item item);
    List<Item> findItemByUserId(Long id);

}
