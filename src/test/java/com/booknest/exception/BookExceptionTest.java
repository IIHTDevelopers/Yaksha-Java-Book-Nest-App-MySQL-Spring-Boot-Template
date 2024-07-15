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

import com.booknest.controller.BookController;
import com.booknest.dto.BookDTO;
import com.booknest.service.BookService;
import com.booknest.utils.MasterData;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetBookByIdNotFoundException() throws Exception {
		Long bookId = 1L;
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Book not found");

		when(this.bookService.getBookById(bookId)).thenThrow(new NotFoundException("Book not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/" + bookId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testAddBookInvalidDataException() throws Exception {
		BookDTO bookDTO = new BookDTO(); // Create an invalid BookDTO

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/books")
				.content(MasterData.asJsonString(bookDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

}
