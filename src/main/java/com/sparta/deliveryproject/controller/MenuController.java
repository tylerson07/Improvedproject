package com.sparta.deliveryproject.controller;

import com.sparta.deliveryproject.dto.CommonResponseDto;
import com.sparta.deliveryproject.dto.MenuRequestDto;
import com.sparta.deliveryproject.dto.MenuResponseDto;
import com.sparta.deliveryproject.exception.DuplicatedMenuException;
import com.sparta.deliveryproject.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{storeId}")
    public ResponseEntity<List<MenuResponseDto>> getMenuListByStore(@PathVariable Long storeId) {
        List<MenuResponseDto> menuList = menuService.getMenuListByStore(storeId);
        return ResponseEntity.status(200).body(menuList);
    }

    @PostMapping("/{storeId}")
    public ResponseEntity<CommonResponseDto> createMenu(@PathVariable Long storeId, @RequestBody MenuRequestDto menuRequestDto) throws DuplicatedMenuException {
        menuService.createMenu(storeId, menuRequestDto);
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "메뉴 등록 성공"));
    }

    @PutMapping("/{menuId}")
    public ResponseEntity<CommonResponseDto> editMenu(@PathVariable Long menuId, @RequestBody MenuRequestDto menuRequestDto) throws DuplicatedMenuException {
        menuService.editMenu(menuId, menuRequestDto);
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "메뉴 수정 성공"));
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<CommonResponseDto> deleteStore(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "메뉴 삭제 성공"));
    }
}
