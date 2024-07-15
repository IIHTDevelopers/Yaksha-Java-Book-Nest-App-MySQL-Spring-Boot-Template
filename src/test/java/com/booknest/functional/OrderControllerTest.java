package com.booknest.functional;

import static com.booknest.utils.MasterData.getOrderDTO;
import static com.booknest.utils.MasterData.getOrderDTOList;
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

import com.booknest.controller.OrderController;
import com.booknest.dto.OrderDTO;
import com.booknest.service.OrderService;
import com.booknest.utils.MasterData;

@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testPlaceOrder() throws Exception {
		OrderDTO orderDTO = getOrderDTO();

		when(orderService.placeOrder(any())).thenReturn(orderDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/orders")
				.content(MasterData.asJsonString(orderDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(orderDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetOrderById() throws Exception {
		OrderDTO orderDTO = getOrderDTO();
		Long orderId = orderDTO.getId();

		when(orderService.getOrderById(orderId)).thenReturn(orderDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/orders/" + orderId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(orderDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetOrdersForUser() throws Exception {
		List<OrderDTO> orderDTOList = getOrderDTOList();
		Long userId = 1L;

		when(orderService.getOrdersForUser(userId)).thenReturn(orderDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/orders/user/" + userId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(orderDTOList)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testUpdateOrderStatus() throws Exception {
		OrderDTO orderDTO = getOrderDTO();
		Long orderId = orderDTO.getId();
		String status = "COMPLETED";

		when(orderService.updateOrderStatus(any(), any())).thenReturn(orderDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/orders/" + orderId + "/status")
				.param("status", status).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(orderDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testProcessPayment() throws Exception {
		OrderDTO orderDTO = getOrderDTO();
		Long orderId = orderDTO.getId();

		when(orderService.processPayment(orderId)).thenReturn(orderDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/orders/" + orderId + "/payment")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(orderDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testCancelOrder() throws Exception {
		Long orderId = 1L;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/orders/" + orderId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 204 ? "true" : "false"), businessTestFile);
	}
}
