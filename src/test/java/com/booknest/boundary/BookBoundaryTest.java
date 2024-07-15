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

import com.booknest.dto.BookDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class BookBoundaryTest {

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
	public void testTitleNotBlank() throws IOException {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("");
		Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTitleNotNull() throws IOException {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle(null);
		Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAuthorNotBlank() throws IOException {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor("");
		Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAuthorNotNull() throws IOException {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor(null);
		Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testCategoryIdsNotNull() throws IOException {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setCategoryIds(null);
		Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testBookPriceNotNull() throws IOException {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setPrice(null);
		Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
