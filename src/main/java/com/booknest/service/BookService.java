package com.booknest.service;

import java.util.List;

import com.booknest.dto.BookDTO;

public interface BookService {

	List<BookDTO> getAllBooks();

	BookDTO getBookById(Long bookId);

	BookDTO addBook(BookDTO bookDTO);

	BookDTO updateBook(Long bookId, BookDTO bookDTO);

	void deleteBook(Long bookId);

	List<BookDTO> searchBooks(String query);
}
