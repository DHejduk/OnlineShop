package com.onlineshop.project.service.impl;

import com.onlineshop.project.model.entity.Item;
import com.onlineshop.project.repository.ItemRepository;
import com.onlineshop.project.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;


    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item findByItemId(Long id) {
        return itemRepository.findByItemId(id);
    }

    @Override
    public Item findByItemName(String name) {
        return itemRepository.findByItemName(name);
    }

    @Override
    public Item findLastAddedItem() {
        return itemRepository.findFirstByOrderByItemIdDesc();
    }

    @Override
    public List<Item> findAllSellingItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }


    public List<Item> findItemByUserId(Long id, String status) {
        return itemRepository.findItemsByUserId(id, status);
    }

    @Override
    public List<Item> findItemWhereUserIdNotIn(Long id, String status) {
        return itemRepository.findItemsNotContainingUserId(id, status);
    }



}
