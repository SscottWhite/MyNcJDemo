package com.example.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("(\\d{2,3})\\-(\\d{2,3})([A-Z]{3})");
		Matcher m = p.matcher("010-002ABC");
		
		if(m.matches()) {
			String str1 = m.group(1);
			String str2 = m.group(2);
			String str3 = m.group(3);
			System.out.println(str1 +";"+ str2 +";" + str3 +";"+ m.group(0));
		}
		
		String s = "the quick brown fox jumps over the lazy dog";
		Pattern pt = Pattern.compile("\\wo\\w");
		Matcher mcMatcher = pt.matcher(s);
		while(mcMatcher.find()) {
			String subString = s.substring(mcMatcher.start(), mcMatcher.end());
			System.out.println(subString);
		}
		String r = s.replaceAll("\\s([a-zA-Z]{3})\\s","<b>$1</b>");
		System.out.println(r);
	}
}
