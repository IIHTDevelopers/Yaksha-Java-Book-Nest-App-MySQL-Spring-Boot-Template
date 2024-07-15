package com.booknest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknest.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	// write logic for finding all reviews by book id

	// write logic for finding all reviews by user id

	// write logic for finding all reviews
}
