package com.example.lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OptionalTest {
//	public static void main(String[] args) {
//		System.out.println(LocalDate.now().isLeapYear());
//		//Stream.of("1,2,3").
//	
//		Stream<String> A = Stream.of(new String[]{"a","b","c"});
//		Stream<String> B = List.of("e","f","g").stream();
//		A.forEach(System.out::println);
//		B.forEach(System.out::println);
//		
//	
//	}
	
//	 public static void main(String[] args){
//	        String nullValue = null;
//	        String optional = Optional.ofNullable(nullValue).orElse("Su");
//	        System.out.println(optional);
//	        String optionalGet = Optional.ofNullable(nullValue).orElseGet(() -> "Xiao");
//	        System.out.println(optionalGet);
//	        String nonNullOptional = Optional.ofNullable("Susan").orElse("Su");
//	        System.out.println(nonNullOptional);
//	        String nonNullOptionalGet = Optional.ofNullable("Molly").orElseGet(() -> "Xiao");
//	        System.out.println(nonNullOptionalGet);	              
//	    }
	
	public static void main(String[] args) {
		 userdto user = new userdto();
		 userdto user2 = new userdto("1","Jack",19);
		 
		String str1 = Optional
				 .ofNullable(user)
				 .map(dto -> dto.getId()).orElse("Rose");
		System.out.println(str1);
				 
	}
}

@Data  //get set
@AllArgsConstructor  //全参构造
@NoArgsConstructor  //无参构造函数
class userdto{
	private String id;
	private String name;
	private Integer age;
}
