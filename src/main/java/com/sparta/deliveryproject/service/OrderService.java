package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.dto.OrderRequestDto;
import com.sparta.deliveryproject.dto.OrderResponseDto;
import com.sparta.deliveryproject.entity.Menu;
import com.sparta.deliveryproject.entity.Orders;
import com.sparta.deliveryproject.entity.User;
import com.sparta.deliveryproject.repository.MenuRepository;
import com.sparta.deliveryproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void createOrders(Long menuId, OrderRequestDto requestDto, User user) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                () -> new NullPointerException("해당 id의 메뉴가 없습니다.")
        );
        if(requestDto.getQuantity() <= 0){
            throw new IllegalArgumentException("수량은 1개 이상이어야 합니다.");
        }

        if(orderRepository.findByMenuId(menuId).isPresent()){
            Orders orders = orderRepository.findByMenuId(menuId).orElseThrow();
            orders.add(requestDto);
        }else{
            Orders orders = new Orders(menu, requestDto, user);
            orderRepository.save(orders);
        }
    }

    public OrderResponseDto getOrders() {
        List<Orders> ordersList = orderRepository.findAll();
        return new OrderResponseDto(ordersList);
    }

    @Transactional
    public void updateOrders(Long menuId, OrderRequestDto requestDto) {
        Orders orders = orderRepository.findByMenuId(menuId).orElseThrow(
                () -> new NullPointerException("해당 id의 메뉴가 장바구니에 없습니다.")
        );
        if(requestDto.getQuantity() <= 0){
            throw new IllegalArgumentException("수량은 1개 이상이어야 합니다.");
        }
        orders.update(requestDto);
    }

    @Transactional
    public void deleteOrders(Long menuId) {
        orderRepository.deleteByMenuId(menuId).orElseThrow(
                () -> new NullPointerException("해당 id의 메뉴가 장바구니에 없습니다.")
        );
    }

    @Transactional
    public void clearOrders() {
        orderRepository.deleteAll();
    }
}
