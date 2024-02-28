package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByMenuId(Long menuId);
}
