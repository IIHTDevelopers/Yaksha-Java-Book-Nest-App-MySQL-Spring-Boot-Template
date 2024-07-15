package com.booknest.exception;

import static com.booknest.utils.TestUtils.currentTest;
import static com.booknest.utils.TestUtils.exceptionTestFile;
import static com.booknest.utils.TestUtils.testReport;
import static com.booknest.utils.TestUtils.yakshaAssert;

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

import com.booknest.controller.AuthorController;
import com.booknest.dto.AuthorDTO;
import com.booknest.service.AuthorService;
import com.booknest.utils.MasterData;

@WebMvcTest(AuthorController.class)
@AutoConfigureMockMvc
public class AuthorExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthorService authorService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddAuthorInvalidDataException() throws Exception {
		AuthorDTO authorDTO = new AuthorDTO(); // Create an invalid AuthorDTO

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/authors")
				.content(MasterData.asJsonString(authorDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}
}
