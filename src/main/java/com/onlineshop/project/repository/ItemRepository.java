package com.onlineshop.project.repository;


import com.onlineshop.project.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findByItemId(Long id);
    Item findByItemName(String name);
    Item findFirstByOrderByItemIdDesc();

    @Query("SELECT i FROM Item i where i.user.userId = ?1")
    List<Item> findItemsByUserId(Long id);

    @Query("SELECT i FROM Item i where i.user.userId not like ?1")
    List<Item> findItemsNotContainingUserId(Long id);

}
