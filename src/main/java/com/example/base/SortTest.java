package com.example.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.dto.UserDTO;


public class SortTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int[] lnt = new int[] {5,2,3,6,4,1};
		Arrays.sort(lnt);
		Collections.addAll(list, 5,2,3,6,4,1);
		Collections.sort(list);

		List<UserDTO> user = new ArrayList<UserDTO>(3);
		user.add(new UserDTO(2,"jack2"));
		user.add(new UserDTO(3,"jack3"));
		user.add(new UserDTO(1,"jack1"));
		user.add(new UserDTO(3,"aack3"));
		/*Collections.sort(user,new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				if(o2.getUserAge().compareTo(o1.getUserAge()) == 0) {
					return -o2.getUserID().compareTo(o1.getUserID());
				} else {
					return o2.getUserAge()-o1.getUserAge();
				}
			}
		});*/
		
		Collections.sort(user);//这边对应的方法就是userDTO里面的重写的方法
		for(UserDTO x: user) {
			System.out.println(x);
		}
	}
}
