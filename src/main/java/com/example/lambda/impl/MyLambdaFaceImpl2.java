package com.example.lambda.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
		 
		 Stream
		 	.of(new UserDTO(1,"j"),new UserDTO(2,"x"))
		 	.map(UserDTO::getUserID)
		 	.forEach(System.out::println);
		 
		 boolean one = Stream.of(12,2,32,24).allMatch(e -> String.valueOf(e).contains(String.valueOf(2)));
		 System.out.println(one);
		 
		// Stream<UserDTO> stream = list.stream();
		 
		List<Integer> list = Arrays.asList(1,3,4,8,2);
		
		Optional<Integer> sum = list.stream().reduce((x,y) -> x+y);
		Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
		Integer sum3 = list.stream().reduce(0, Integer::sum);
		
		System.out.println(sum2.get()+";"+sum3);
		
	}
}
