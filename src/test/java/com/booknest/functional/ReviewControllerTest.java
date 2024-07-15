package com.booknest.functional;

import static com.booknest.utils.MasterData.getReviewDTO;
import static com.booknest.utils.MasterData.getReviewDTOList;
import static com.booknest.utils.TestUtils.businessTestFile;
import static com.booknest.utils.TestUtils.currentTest;
import static com.booknest.utils.TestUtils.testReport;
import static com.booknest.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class ReviewControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReviewService reviewService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddReview() throws Exception {
		ReviewDTO reviewDTO = getReviewDTO();

		when(reviewService.addReview(any())).thenReturn(reviewDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/reviews")
				.content(MasterData.asJsonString(reviewDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(reviewDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetReviewsForBook() throws Exception {
		List<ReviewDTO> reviewDTOList = getReviewDTOList();
		Long bookId = 1L;

		when(reviewService.getReviewsForBook(bookId)).thenReturn(reviewDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reviews/book/" + bookId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(reviewDTOList)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testUpdateReview() throws Exception {
		ReviewDTO reviewDTO = getReviewDTO();
		Long reviewId = reviewDTO.getId();

		when(reviewService.updateReview(any(), any())).thenReturn(reviewDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/reviews/" + reviewId)
				.content(MasterData.asJsonString(reviewDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(reviewDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testDeleteReview() throws Exception {
		Long reviewId = 1L;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/reviews/" + reviewId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 204 ? "true" : "false"), businessTestFile);
	}

	@Test
	public void testGetReviewsForUser() throws Exception {
		List<ReviewDTO> reviewDTOList = getReviewDTOList();
		Long userId = 1L;

		when(reviewService.getReviewsForUser(userId)).thenReturn(reviewDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reviews/user/" + userId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(reviewDTOList)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetAllReviews() throws Exception {
		List<ReviewDTO> reviewDTOList = getReviewDTOList();

		when(reviewService.getAllReviews()).thenReturn(reviewDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reviews")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(reviewDTOList)) ? "true"
						: "false",
				businessTestFile);
	}
}
