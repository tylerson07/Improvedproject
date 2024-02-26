package com.sparta.deliveryproject.controller;

import com.sparta.deliveryproject.dto.CommonResponseDto;
import com.sparta.deliveryproject.dto.OrderRequestDto;
import com.sparta.deliveryproject.dto.OrderResponseDto;
import com.sparta.deliveryproject.entity.Orders;
import com.sparta.deliveryproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<OrderResponseDto> getOrders(){
        OrderResponseDto responseDto = orderService.getOrders();
        return ResponseEntity.status(200).body(responseDto);
    }
    @PostMapping("/{menuId}")
    public ResponseEntity<CommonResponseDto> createOrders(@PathVariable Long menuId, @RequestBody OrderRequestDto requestDto){
        orderService.createOrders(menuId, requestDto);
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "장바구니 등록 성공"));
    }

    @PutMapping("/{menuId}")
    public ResponseEntity<CommonResponseDto> updateOrders(@PathVariable Long menuId, @RequestBody OrderRequestDto requestDto){
        orderService.updateOrders(menuId, requestDto);
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "장바구니 메뉴 수정 성공"));
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<CommonResponseDto> deleteOrders(@PathVariable Long menuId){
        orderService.deleteOrders(menuId);
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "장바구니 메뉴 삭제 성공"));
    }

    @DeleteMapping()
    public ResponseEntity<CommonResponseDto> clearOrders(){
        orderService.clearOrders();
        return ResponseEntity.status(200).body(new CommonResponseDto(200, "장바구니 비우기 성공"));
    }
}
