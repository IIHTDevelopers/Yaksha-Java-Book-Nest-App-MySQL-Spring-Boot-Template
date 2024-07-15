package com.booknest.service;

import java.util.List;

import com.booknest.dto.ReviewDTO;

public interface ReviewService {

	ReviewDTO addReview(ReviewDTO reviewDTO);

	List<ReviewDTO> getReviewsForBook(Long bookId);

	ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO);

	void deleteReview(Long reviewId);

	List<ReviewDTO> getReviewsForUser(Long userId);

	List<ReviewDTO> getAllReviews();
}
