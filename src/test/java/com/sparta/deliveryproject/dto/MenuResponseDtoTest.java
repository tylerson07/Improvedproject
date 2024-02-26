package com.sparta.deliveryproject.dto;

import com.sparta.deliveryproject.entity.Menu;
import com.sparta.deliveryproject.entity.Store;
import com.sparta.deliveryproject.test.CommonTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuResponseDtoTest implements CommonTest {
    @DisplayName("Menu entity 에서 MenuResponseDto")
    @Nested
    class createMenuResponseDtoTest {

        @DisplayName("MenuResponseDto 변환 성공")
        @Test
        void createStoreRequestDto_success() {
            // given
            StoreRequestDto storeRequestDto = new StoreRequestDto();

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
    }
}