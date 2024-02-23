package com.sparta.deliveryproject.dto;

import com.sparta.deliveryproject.entity.CategoryEnum;
import com.sparta.deliveryproject.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreResponseDto {
    private String name;
    private String address;
    private CategoryEnum category;

    public StoreResponseDto(Store store) {
        this.name = store.getName();
        this.address = store.getAddress();
        this.category = store.getCategory();
    }
}
