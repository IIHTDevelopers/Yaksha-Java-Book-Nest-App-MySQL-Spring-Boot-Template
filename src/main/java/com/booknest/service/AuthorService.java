package com.booknest.service;

import java.util.List;

import com.booknest.dto.AuthorDTO;

public interface AuthorService {

	List<AuthorDTO> getAllAuthors();

	AuthorDTO addAuthor(AuthorDTO authorDTO);
}
