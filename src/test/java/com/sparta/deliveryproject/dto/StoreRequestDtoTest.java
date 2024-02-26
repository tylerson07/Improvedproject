package com.sparta.deliveryproject.dto;

import com.sparta.deliveryproject.test.CommonTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreRequestDtoTest implements CommonTest {
    @DisplayName("StoreRequestDto 생성")
    @Nested
    class createStoreRequestDto {
        @DisplayName("StoreRequestDto 생성 성공")
        @Test
        void createStoreRequestDto_success() {
            // given - when
            StoreRequestDto storeRequestDto = new StoreRequestDto();
            storeRequestDto.setName(TEST_STORE_NAME);
            storeRequestDto.setIntroduce(TEST_STORE_INTRODUCE);
            storeRequestDto.setAddress(TEST_STORE_ADDRESS);
            storeRequestDto.setCategory(TEST_STORE_CATEGORY);

            // then
            assertEquals(storeRequestDto.getName(), TEST_STORE_NAME);
            assertEquals(storeRequestDto.getIntroduce(), TEST_STORE_INTRODUCE);
            assertEquals(storeRequestDto.getAddress(), TEST_STORE_ADDRESS);
            assertEquals(storeRequestDto.getCategory(), TEST_STORE_CATEGORY);
        }
    }
}