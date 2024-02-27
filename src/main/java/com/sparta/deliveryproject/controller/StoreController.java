package com.sparta.deliveryproject.controller;

import com.sparta.deliveryproject.dto.CommonResponseDto;
import com.sparta.deliveryproject.dto.StoreRequestDto;
import com.sparta.deliveryproject.dto.StoreResponseDto;
import com.sparta.deliveryproject.entity.CategoryEnum;
import com.sparta.deliveryproject.security.UserDetailsImpl;
import com.sparta.deliveryproject.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    // 카테고리별 메장 조회
    @GetMapping("/{category}")
    public ResponseEntity<List<StoreResponseDto>> getStoreListByCategory(@PathVariable CategoryEnum category) {
        List<StoreResponseDto> storeList = storeService.getStoreListByCategory(category);
        return ResponseEntity.status(200).body(storeList);
    }

    // 매장 등록
    @Secured("ADMIN")
    @PostMapping()
    public ResponseEntity<CommonResponseDto> createStore(@RequestBody StoreRequestDto storeRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.createStore(storeRequestDto, userDetails.getUser());
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "매장 등록 성공"));
    }

    // 매장 수정
    @Secured("ADMIN")
    @PutMapping("/{storeId}")
    public ResponseEntity<CommonResponseDto> editStore(@PathVariable Long storeId, @RequestBody StoreRequestDto storeRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.editStore(storeId, storeRequestDto, userDetails.getUser());
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "매장 수정 성공"));
    }

    // 매장 삭제
    @Secured("ADMIN")
    @DeleteMapping("/{storeId}")
    public ResponseEntity<CommonResponseDto> deleteStore(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.deleteStore(storeId, userDetails.getUser());
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "매장 삭제 성공"));
    }
}
