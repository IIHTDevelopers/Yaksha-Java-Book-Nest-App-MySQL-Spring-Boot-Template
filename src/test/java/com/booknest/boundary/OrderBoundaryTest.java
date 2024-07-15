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

import com.booknest.dto.OrderDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class OrderBoundaryTest {

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
	public void testOrderUserIdNotNull() throws IOException {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setUserId(null);
		Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testOrderDateNotNull() throws IOException {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderDate(null);
		Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testStatusNotNull() throws IOException {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setStatus(null);
		Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTotalAmountNotNull() throws IOException {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setTotalAmount(null);
		Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testItemsNotNull() throws IOException {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setItems(null);
		Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
