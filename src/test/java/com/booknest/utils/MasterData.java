package com.booknest.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.booknest.dto.AuthorDTO;
import com.booknest.dto.BookDTO;
import com.booknest.dto.CategoryDTO;
import com.booknest.dto.OrderDTO;
import com.booknest.dto.OrderItemDTO;
import com.booknest.dto.ReviewDTO;
import com.booknest.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MasterData {

	public static UserDTO getUserDTO() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		userDTO.setUsername("john_doe");
		userDTO.setEmail("john.doe@example.com");
		userDTO.setPassword("password123");
		userDTO.setFirstName("John");
		userDTO.setLastName("Doe");
		return userDTO;
	}

	public static List<UserDTO> getUserDTOList() {
		List<UserDTO> userDTOList = new ArrayList<>();
		userDTOList.add(getUserDTO());
		return userDTOList;
	}

	public static AuthorDTO getAuthorDTO() {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(1L);
		authorDTO.setName("Jane Austen");
		return authorDTO;
	}

	public static List<AuthorDTO> getAuthorDTOList() {
		List<AuthorDTO> authorDTOList = new ArrayList<>();
		authorDTOList.add(getAuthorDTO());
		return authorDTOList;
	}

	public static CategoryDTO getCategoryDTO() {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(1L);
		categoryDTO.setName("Fiction");
		return categoryDTO;
	}

	public static List<CategoryDTO> getCategoryDTOList() {
		List<CategoryDTO> categoryDTOList = new ArrayList<>();
		categoryDTOList.add(getCategoryDTO());
		return categoryDTOList;
	}

	public static BookDTO getBookDTO() {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(1L);
		bookDTO.setTitle("Pride and Prejudice");
		bookDTO.setAuthor("Jane Austen");
		Set<Long> categoryIds = new HashSet<>();
		categoryIds.add(1L);
		bookDTO.setCategoryIds(categoryIds);
		bookDTO.setPrice(BigDecimal.valueOf(19.99));
		bookDTO.setDescription("A classic novel");
		return bookDTO;
	}

	public static List<BookDTO> getBookDTOList() {
		List<BookDTO> bookDTOList = new ArrayList<>();
		bookDTOList.add(getBookDTO());
		return bookDTOList;
	}

	public static OrderItemDTO getOrderItemDTO() {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setId(1L);
		orderItemDTO.setBookId(1L);
		orderItemDTO.setQuantity(1);
		orderItemDTO.setPrice(BigDecimal.valueOf(19.99));
		return orderItemDTO;
	}

	public static List<OrderItemDTO> getOrderItemDTOList() {
		List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
		orderItemDTOList.add(getOrderItemDTO());
		return orderItemDTOList;
	}

	public static OrderDTO getOrderDTO() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(1L);
		orderDTO.setUserId(1L);
		orderDTO.setOrderDate(new Date());
		orderDTO.setStatus("PENDING");
		orderDTO.setTotalAmount(BigDecimal.valueOf(19.99));
		orderDTO.setItems(new HashSet<>(getOrderItemDTOList()));
		return orderDTO;
	}

	public static List<OrderDTO> getOrderDTOList() {
		List<OrderDTO> orderDTOList = new ArrayList<>();
		orderDTOList.add(getOrderDTO());
		return orderDTOList;
	}

	public static ReviewDTO getReviewDTO() {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setId(1L);
		reviewDTO.setUserId(1L);
		reviewDTO.setBookId(1L);
		reviewDTO.setRating(5);
		reviewDTO.setComment("Excellent book!");
		return reviewDTO;
	}

	public static List<ReviewDTO> getReviewDTOList() {
		List<ReviewDTO> reviewDTOList = new ArrayList<>();
		reviewDTOList.add(getReviewDTO());
		return reviewDTOList;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String randomStringWithSize(int size) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < size; i++) {
			s.append("A");
		}
		return s.toString();
	}
}
