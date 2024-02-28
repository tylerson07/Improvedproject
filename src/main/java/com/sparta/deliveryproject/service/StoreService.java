package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.dto.StoreRequestDto;
import com.sparta.deliveryproject.dto.StoreResponseDto;
import com.sparta.deliveryproject.entity.CategoryEnum;
import com.sparta.deliveryproject.entity.Store;
import com.sparta.deliveryproject.entity.User;
import com.sparta.deliveryproject.entity.UserRoleEnum;
import com.sparta.deliveryproject.exception.NotValidCategoryException;
import com.sparta.deliveryproject.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<StoreResponseDto> getStoreListByCategory(CategoryEnum category) {
        List<Store> storeList = storeRepository.findAllByCategory(category);

        if (storeList.isEmpty()) {
            throw new IllegalArgumentException(category + "에 속하는 식당이 없습니다.");
        }

        return storeList.stream()
                .map(StoreResponseDto::new)
                .toList();
    }

    public void createStore(StoreRequestDto storeRequestDto, User user) {
        try {
            CategoryEnum.valueOf(storeRequestDto.getCategory());
        } catch (IllegalArgumentException e) {
            throw new NotValidCategoryException("존재하지 않는 카테고리입니다.");
        }

        Store store = new Store(storeRequestDto, user);
        storeRepository.save(store);
    }

    public void editStore(Long id, StoreRequestDto storeRequestDto, User userDetails) {
        try {
            CategoryEnum.valueOf(storeRequestDto.getCategory());
        } catch (IllegalArgumentException e) {
            throw new NotValidCategoryException("존재하지 않는 카테고리입니다.");
        }

        Store store = storeRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 id의 store가 존재하지 않습니다.")
        );

        if(!store.getUser().getUserID().equals(userDetails.getUserID())){
            throw new IllegalArgumentException("매장을 수정할 수 있는 권한이 없습니다.");
        }

        store.edit(storeRequestDto);
    }

    public void deleteStore(Long id, User userDetails) {
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 id의 store가 존재하지 않습니다.")
        );

        if(!store.getUser().getUserID().equals(userDetails.getUserID())){
            throw new IllegalArgumentException("매장을 삭제할 수 있는 권한이 없습니다.");
        }

        storeRepository.delete(store);
    }
}
