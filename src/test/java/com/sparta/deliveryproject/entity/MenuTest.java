package com.sparta.deliveryproject.entity;

import com.sparta.deliveryproject.dto.MenuRequestDto;
import com.sparta.deliveryproject.dto.MenuResponseDto;
import com.sparta.deliveryproject.dto.StoreRequestDto;
import com.sparta.deliveryproject.test.CommonTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest implements CommonTest {
    @DisplayName("Menu 생성자 테스트")
    @Test
    void createMenu_success() {
        // given
        StoreRequestDto storeRequestDto = new StoreRequestDto();
        storeRequestDto.setName(TEST_STORE_NAME);
        storeRequestDto.setIntroduce(TEST_STORE_INTRODUCE);
        storeRequestDto.setAddress(TEST_STORE_ADDRESS);
        storeRequestDto.setCategory(TEST_STORE_CATEGORY);

        Store store = new Store(storeRequestDto);

        MenuRequestDto menuRequestDto = new MenuRequestDto();
        menuRequestDto.setName(TEST_MENU_NAME);
        menuRequestDto.setIntroduce(TEST_MENU_INTRODUCE);
        menuRequestDto.setPrice(TEST_MENU_PRICE);

        Menu menu = new Menu(store, menuRequestDto, 5000);

        // when
        MenuResponseDto menuResponseDto = new MenuResponseDto(menu);

        // then
        assertEquals(menuResponseDto.getName(), TEST_MENU_NAME);
        assertEquals(menuResponseDto.getPrice(), 5000);
        assertEquals(menuResponseDto.getIntroduce(), TEST_MENU_INTRODUCE);
    }

    @DisplayName("Menu update 테스트")
    @Test
    void updateMenu_success() {
        // given
        MenuRequestDto menuRequestDto = new MenuRequestDto();
        menuRequestDto.setName(TEST_MENU_NAME);
        menuRequestDto.setIntroduce(TEST_MENU_INTRODUCE);
        menuRequestDto.setPrice(TEST_MENU_PRICE);

        Menu menu = new Menu();

        menu.update(menuRequestDto, 5000);

        // then
        assertEquals(menu.getName(), TEST_MENU_NAME);
        assertEquals(menu.getPrice(), 5000);
        assertEquals(menu.getIntroduce(), TEST_MENU_INTRODUCE);
    }
}