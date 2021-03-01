package com.example.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;


public class LoggerTest {
	//
	private static final Logger logger = LoggerFactory.getLogger(Logger.class);
	
	public static void main(String[] args) {
		logger.info("1-2-3-4-5-6");
	}
}
