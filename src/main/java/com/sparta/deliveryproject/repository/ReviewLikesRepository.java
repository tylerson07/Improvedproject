package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.entity.Review;
import com.sparta.deliveryproject.entity.ReviewLikes;
import com.sparta.deliveryproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewLikesRepository  extends JpaRepository<ReviewLikes, Long> {
    Optional<ReviewLikes> findByUserAndReview(User user, Review review);

    int countByReview_Id(Long reviewId);
}
