package com.example.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.DTO.UserDTO;
import com.example.serviceImpl.MapImpl;

public class FanXing {
	
	public static void main(String[] args) {
		UserDTO user = new UserDTO();
		ArrayList<String> list = new ArrayList<String>();
		MapIF<String, Integer> mapIF = new MapImpl<String, Integer>("看样子",04);

		user.setUserAge(22);
		user.setUserID("007");
		
		list.add("09");
		list.add("08");
		user.setUserInfo(list);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(getInfo(user.getUserInfo()));
		System.out.println(mapIF.getKey());
		System.out.println(((MapImpl)mapIF).getKV());//当然也能这么强制转
		System.out.println( Optional.ofNullable(user.getUserID()).isPresent());//取代  != null
	}
	
	//泛型实例, 
	public static <T> T getInfo(T obj) {
		return obj;
	}
	
	public String face5(String str) {
		 return str + ";;";
	}
	
	
}	
