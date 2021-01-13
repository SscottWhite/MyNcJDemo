package com.example.lambda.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.DTO.UserDTO;
import com.example.lambda.NumberProvider;

public class MyLambdaFaceImpl2 {
	 public static void main(String[] args) {
		
		/* List<UserDTO> list = new LinkedList<UserDTO>();
		 for (int i = 1; i <= 10; i++) {
			 UserDTO userDTO = new UserDTO(i,"jack"+i);
			 list.add(userDTO);
		 }
		 NumberProvider numberProvider = (x, y) -> {
			return y.stream()
					.filter(y1 -> y1.getUserAge() > x)
					.collect(Collectors.toList());
		 };
		 List<UserDTO> list2 =  numberProvider.getUserList(5, list);
		 System.out.println(list2);*/
	}
	 
	 
}
