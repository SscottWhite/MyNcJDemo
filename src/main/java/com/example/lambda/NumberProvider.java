package com.example.lambda;

import java.util.List;

import com.example.dto.UserDTO;

@FunctionalInterface
public interface NumberProvider {
	List<UserDTO> getUserList(int age, List<UserDTO> dtoList);
}
