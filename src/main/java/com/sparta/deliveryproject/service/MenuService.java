package com.sparta.deliveryproject.service;


import com.sparta.deliveryproject.dto.MenuRequestDto;
import com.sparta.deliveryproject.dto.MenuResponseDto;
import com.sparta.deliveryproject.entity.Menu;
import com.sparta.deliveryproject.entity.Store;
import com.sparta.deliveryproject.repository.MenuRepository;
import com.sparta.deliveryproject.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<MenuResponseDto> getMenuListByStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new NullPointerException("해당 id의 매장이 없습니다.")
        );
        List<Menu> menuList = menuRepository.findAllByStore(store);

        if (menuList.isEmpty()) {
            throw new NullPointerException("해당 매장에 메뉴가 없습니다.");
        }

        return menuList.stream().map(MenuResponseDto::new).toList();
    }

    public void createMenu(Long storeId, MenuRequestDto menuRequestDto) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new NullPointerException("해당 id의 매장이 없습니다.")
        );
        Menu menu = new Menu(store, menuRequestDto);
        menuRepository.save(menu);
    }

    public void editMenu(Long menuId, MenuRequestDto menuRequestDto) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                () -> new NullPointerException("해당 id의 메뉴가 없습니다.")
        );
        menu.update(menuRequestDto);
    }

    public void deleteMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                () -> new NullPointerException("해당 id의 메뉴가 없습니다.")
        );
        menuRepository.delete(menu);
    }
}
