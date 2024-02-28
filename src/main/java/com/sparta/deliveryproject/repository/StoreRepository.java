package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.entity.Category;
import com.sparta.deliveryproject.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByCategory(Category category);
}
