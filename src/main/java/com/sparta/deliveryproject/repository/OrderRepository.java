package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findByMenuId(Long menuId);

    Optional<Orders> deleteByMenuId(Long menuId);
}
