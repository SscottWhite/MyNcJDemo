package com.example.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameters;

public class JunitTest {
	
	UnitTest ut = new UnitTest();
	
//	@BeforeEach
//	public void up() {
//		this.ut = new UnitTest();
//	}
//	
//	@AfterEach
//	public void down() {
//		this.ut = null;
//	}
	
	@Test
	@Disabled
	//参数化test, 可以自带参数 , 和@Test不一样, 但不要省略@Test
	@ParameterizedTest
	@ValueSource(strings = {"ss","cc"})
	public void test() {
		
	//	System.out.println(ut.getInt("123") + ";"+ y);
		
		assertEquals(1, ut.getInt("12"));
		
		
	
	}
	
	@Test
	//@Disabled
	public void test2() {
		assertTrue("123对的", ut.getInt("123") != 123);
	}
}

class UnitTest{
	public int getInt(String str) {
		return Integer.parseInt(str);
	}
}