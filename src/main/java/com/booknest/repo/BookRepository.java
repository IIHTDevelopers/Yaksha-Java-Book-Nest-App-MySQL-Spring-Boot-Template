package com.booknest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknest.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	// write logic for finding all books by passed query

	// write logic for finding a book by book id
}
