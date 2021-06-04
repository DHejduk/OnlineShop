package com.onlineshop.project.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private Long itemId;
    private String itemName;
    private BigDecimal value;
}
