package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.dto.StoreRequestDto;
import com.sparta.deliveryproject.entity.Store;
import com.sparta.deliveryproject.entity.User;
import com.sparta.deliveryproject.entity.UserRoleEnum;
import com.sparta.deliveryproject.repository.StoreRepository;
import com.sparta.deliveryproject.security.UserDetailsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {

    @Mock
    StoreRepository storeRepository;

    private UserDetailsImpl UserAdminSetup() {
        String username = "testUserAdmin";
        String password = "testUserAdmin";
        String address = "testUserAdmin";
        UserRoleEnum role = UserRoleEnum.ADMIN;

        User testUserAdmin = new User(username, password, address, role);
        return new UserDetailsImpl(testUserAdmin);
    }

    @Nested
    class createStoreTest {

        @Test
        @DisplayName("createStore 성공")
        void createStoreTest_success() {
            UserDetailsImpl userDetails = UserAdminSetup();

            StoreRequestDto storeRequestDto = new StoreRequestDto();
            storeRequestDto.setCategory("CHINESE");
            storeRequestDto.setIntroduce("건대 유명 중국음식점");
            storeRequestDto.setAddress("서울시 광진구");
            storeRequestDto.setName("시옌");

            Store store = new Store(storeRequestDto, userDetails.getUser());

            StoreService storeService = new StoreService(storeRepository);
            storeService.createStore(storeRequestDto, userDetails.getUser());
        }


        @Test
        @DisplayName("createStore 실패")
        void createStoreTest_fail() {
            UserDetailsImpl userDetails = UserAdminSetup();

            StoreRequestDto storeRequestDto = new StoreRequestDto();
            storeRequestDto.setCategory("CHINESsE");
            storeRequestDto.setIntroduce("건대 유명 중국음식점");
            storeRequestDto.setAddress("서울시 광진구");
            storeRequestDto.setName("시옌");

            Store store = new Store(storeRequestDto, userDetails.getUser());

            StoreService storeService = new StoreService(storeRepository);
            storeService.createStore(storeRequestDto, userDetails.getUser());
        }
    }
}