package com.booknest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booknest.dto.BookDTO;
import com.booknest.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public List<BookDTO> getAllBooks() {
		// write your logic here
		return null;
	}

	@Override
	public BookDTO getBookById(Long bookId) {
		// write your logic here
		return null;
	}

	@Override
	public BookDTO addBook(BookDTO bookDTO) {
		// write your logic here
		return null;
	}

	@Override
	public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
		// write your logic here
		return null;
	}

	@Override
	public void deleteBook(Long bookId) {
		// write your logic here
	}

	@Override
	public List<BookDTO> searchBooks(String query) {
		// write your logic here
		return null;
	}
}
