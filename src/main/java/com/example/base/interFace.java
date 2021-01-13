package com.example.base;

@FunctionalInterface
public interface interFace {
	 void run();
	 
	 default void cry() {}
	 
	 static void mouth() {}
}
