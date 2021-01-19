package com.example.lambda.function;

import java.util.ArrayList;
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
		
		
		
	}
}
