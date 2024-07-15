package com.booknest.functional;

import static com.booknest.utils.MasterData.getCategoryDTO;
import static com.booknest.utils.MasterData.getCategoryDTOList;
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

import com.booknest.controller.CategoryController;
import com.booknest.dto.CategoryDTO;
import com.booknest.service.CategoryService;
import com.booknest.utils.MasterData;

@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc
public class CategoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddCategory() throws Exception {
		CategoryDTO categoryDTO = getCategoryDTO();

		when(categoryService.addCategory(any())).thenReturn(categoryDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/categories")
				.content(MasterData.asJsonString(categoryDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(categoryDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetAllCategories() throws Exception {
		List<CategoryDTO> categoryDTOList = getCategoryDTOList();

		when(categoryService.getAllCategories()).thenReturn(categoryDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(categoryDTOList))
						? "true"
						: "false",
				businessTestFile);
	}
}
