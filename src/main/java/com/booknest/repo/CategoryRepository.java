package com.booknest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknest.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	// write logic for finding category by name

	// write logic for finding all categories
}
