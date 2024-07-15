package com.booknest.service;

import com.booknest.dto.UserDTO;

public interface UserService {

	UserDTO registerUser(UserDTO userDTO);

	UserDTO getUserProfile(Long userId);

	UserDTO updateUserProfile(Long userId, UserDTO userDTO);
}
