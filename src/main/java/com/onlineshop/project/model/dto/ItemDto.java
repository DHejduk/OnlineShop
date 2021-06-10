package com.onlineshop.project.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ItemDto {
    @NotNull
    @NotEmpty
    private Long itemId;
    @NotNull
    @NotEmpty
    private String itemName;
    @NotNull
    @NotEmpty
    private String price;

    private String description;

    private String imgUrl;
}
