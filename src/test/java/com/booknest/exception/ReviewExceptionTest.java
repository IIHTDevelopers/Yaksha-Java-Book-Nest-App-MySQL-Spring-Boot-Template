package com.booknest.exception;

import static com.booknest.utils.TestUtils.currentTest;
import static com.booknest.utils.TestUtils.exceptionTestFile;
import static com.booknest.utils.TestUtils.testReport;
import static com.booknest.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.booknest.controller.ReviewController;
import com.booknest.dto.ReviewDTO;
import com.booknest.service.ReviewService;
import com.booknest.utils.MasterData;

@WebMvcTest(ReviewController.class)
@AutoConfigureMockMvc
public class ReviewExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReviewService reviewService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddReviewInvalidDataException() throws Exception {
		ReviewDTO reviewDTO = new ReviewDTO(); // Create an invalid ReviewDTO

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/reviews")
				.content(MasterData.asJsonString(reviewDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

}
