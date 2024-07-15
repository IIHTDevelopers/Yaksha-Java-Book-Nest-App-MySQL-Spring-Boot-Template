package com.booknest.service;

import java.util.List;

import com.booknest.dto.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();

	CategoryDTO addCategory(CategoryDTO categoryDTO);
}
