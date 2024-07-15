package com.booknest.functional;

import static com.booknest.utils.MasterData.getAuthorDTO;
import static com.booknest.utils.MasterData.getAuthorDTOList;
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

import com.booknest.controller.AuthorController;
import com.booknest.dto.AuthorDTO;
import com.booknest.service.AuthorService;
import com.booknest.utils.MasterData;

@WebMvcTest(AuthorController.class)
@AutoConfigureMockMvc
public class AuthorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthorService authorService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddAuthor() throws Exception {
		AuthorDTO authorDTO = getAuthorDTO();

		when(authorService.addAuthor(any())).thenReturn(authorDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/authors")
				.content(MasterData.asJsonString(authorDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(authorDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetAllAuthors() throws Exception {
		List<AuthorDTO> authorDTOList = getAuthorDTOList();

		when(authorService.getAllAuthors()).thenReturn(authorDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/authors")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(authorDTOList)) ? "true"
						: "false",
				businessTestFile);
	}
}
