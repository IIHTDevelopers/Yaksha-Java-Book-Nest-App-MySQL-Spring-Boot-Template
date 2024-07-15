package com.booknest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booknest.dto.ReviewDTO;
import com.booknest.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Override
	public ReviewDTO addReview(ReviewDTO reviewDTO) {
		// write your logic here
		return null;
	}

	@Override
	public List<ReviewDTO> getReviewsForBook(Long bookId) {
		// write your logic here
		return null;
	}

	@Override
	public ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO) {
		// write your logic here
		return null;
	}

	@Override
	public void deleteReview(Long reviewId) {
		// write your logic here
	}

	@Override
	public List<ReviewDTO> getReviewsForUser(Long userId) {
		// write your logic here
		return null;
	}

	@Override
	public List<ReviewDTO> getAllReviews() {
		// write your logic here
		return null;
	}
}
