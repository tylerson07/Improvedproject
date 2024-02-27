package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.repository.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {
    @MockBean
    StoreRepository storeRepository;

    @Nested
    class getScoreListTest {

        @Test
        @DisplayName("getScoreList 성공")
        void test01(){

        }

    }
}