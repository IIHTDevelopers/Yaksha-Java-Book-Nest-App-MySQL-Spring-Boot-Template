package com.booknest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknest.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	// write logic for finding an author by name

	// write logic for finding all authors
}
