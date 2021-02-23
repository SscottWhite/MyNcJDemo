package com.example.lambda.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTest {
	/**
	 * 1 三种方式, 
	    Optional<T> reduce(BinaryOperator<T> accumulator);
	   
		T reduce(T identity, BinaryOperator<T> accumulator);
		
		<U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);

	 * @param args
	 */
	public static void main(String[] args) {
		Integer one = Stream.of(1,2,3,4).reduce((a,b) -> a+b).get();
		Integer two = Stream.of(1,2,3,4).reduce(5,(a,b) -> a+b);
		Long three = Stream.of(1,2,3,4).reduce(0L,(a,b) -> a+b,(a,b)->0L);
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		ArrayList<Integer> accResult_s = Stream.of(1,2,3,4)
                .reduce(newList,
                        (acc, item) -> {
                            acc.add(item);
                            return acc;
                        }, (acc, item) -> null);
		System.out.println(one + ";"+ two + ";"+ three +";"+ accResult_s);
		
		IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);
		System.out.println();
		IntStream.range(1, 3).forEach(System.out::print);// [ )
		System.out.println();
		IntStream.rangeClosed(1, 3).forEach(System.out::print);// [ ]
		
		//ecplise
		//IDEA
		
		List<Optional<String>> list1 = Arrays.asList (
			      Optional.empty(), 
			      Optional.of("A"), 
			      Optional.empty(), 
			      Optional.of("B"));		
		List<String> list2 = list1
					.stream()
					.flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
					.collect(Collectors.toList());
		List<String> list3 = list1.stream().flatMap(Optional::stream).collect(Collectors.toList());
		
		System.out.println(list2);
		System.out.println(list3);
	}
}
