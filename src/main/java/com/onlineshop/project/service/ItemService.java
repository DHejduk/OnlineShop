package com.onlineshop.project.service;

import com.onlineshop.project.model.entity.Item;

public interface ItemService {
    void update(Item item);
    void save(Item item);
    Item findByItemId(Long id);
    Item findByItemName(String name);
    Item findLastAddedItem();
}
