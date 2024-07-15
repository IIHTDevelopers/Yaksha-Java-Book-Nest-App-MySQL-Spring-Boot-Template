package com.booknest.functional;

import static com.booknest.utils.MasterData.getBookDTO;
import static com.booknest.utils.MasterData.getBookDTOList;
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

import com.booknest.controller.BookController;
import com.booknest.dto.BookDTO;
import com.booknest.service.BookService;
import com.booknest.utils.MasterData;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddBook() throws Exception {
		BookDTO bookDTO = getBookDTO();

		when(bookService.addBook(any())).thenReturn(bookDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/books")
				.content(MasterData.asJsonString(bookDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(bookDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetAllBooks() throws Exception {
		List<BookDTO> bookDTOList = getBookDTOList();

		when(bookService.getAllBooks()).thenReturn(bookDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(bookDTOList)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetBookById() throws Exception {
		BookDTO bookDTO = getBookDTO();
		Long bookId = bookDTO.getId();

		when(bookService.getBookById(bookId)).thenReturn(bookDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/" + bookId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(bookDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testUpdateBook() throws Exception {
		BookDTO bookDTO = getBookDTO();
		Long bookId = bookDTO.getId();

		when(bookService.updateBook(any(), any())).thenReturn(bookDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/books/" + bookId)
				.content(MasterData.asJsonString(bookDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(bookDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testDeleteBook() throws Exception {
		Long bookId = 1L;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/books/" + bookId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 204 ? "true" : "false"), businessTestFile);
	}

	@Test
	public void testSearchBooks() throws Exception {
		List<BookDTO> bookDTOList = getBookDTOList();
		String query = "test";

		when(bookService.searchBooks(query)).thenReturn(bookDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/search").param("query", query)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(bookDTOList)) ? "true"
						: "false",
				businessTestFile);
	}
}
