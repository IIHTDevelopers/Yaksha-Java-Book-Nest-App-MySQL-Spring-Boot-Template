package com.booknest.boundary;

import static com.booknest.utils.TestUtils.boundaryTestFile;
import static com.booknest.utils.TestUtils.currentTest;
import static com.booknest.utils.TestUtils.testReport;
import static com.booknest.utils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.booknest.dto.ReviewDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ReviewBoundaryTest {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testReviewUserIdNotNull() throws IOException {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setUserId(null);
		Set<ConstraintViolation<ReviewDTO>> violations = validator.validate(reviewDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testReviewBookIdNotNull() throws IOException {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setBookId(null);
		Set<ConstraintViolation<ReviewDTO>> violations = validator.validate(reviewDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testRatingNotNull() throws IOException {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setRating(null);
		Set<ConstraintViolation<ReviewDTO>> violations = validator.validate(reviewDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testRatingMinValue() throws IOException {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setRating(0); // less than min value
		Set<ConstraintViolation<ReviewDTO>> violations = validator.validate(reviewDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testRatingMaxValue() throws IOException {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setRating(6); // more than max value
		Set<ConstraintViolation<ReviewDTO>> violations = validator.validate(reviewDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
