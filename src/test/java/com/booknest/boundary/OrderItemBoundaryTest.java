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

import com.booknest.dto.OrderItemDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class OrderItemBoundaryTest {

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
	public void testOrderedBookIdNotNull() throws IOException {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setBookId(null);
		Set<ConstraintViolation<OrderItemDTO>> violations = validator.validate(orderItemDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testQuantityNotNull() throws IOException {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setQuantity(null);
		Set<ConstraintViolation<OrderItemDTO>> violations = validator.validate(orderItemDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testOrderedBookPriceNotNull() throws IOException {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setPrice(null);
		Set<ConstraintViolation<OrderItemDTO>> violations = validator.validate(orderItemDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
