package com.example.demo;

import java.util.EnumSet;

public class EnumTest {
	public static void main(String[] args) {
		//枚举集合测试	
		EnumSet<WeekDay> week = EnumSet.noneOf(WeekDay.class);
        week.add(WeekDay.MON);
        System.out.println("EnumSet中的元素：" + week);
        week.remove(WeekDay.MON);
        System.out.println("EnumSet中的元素：" + week);
        week.addAll(EnumSet.complementOf(week));
        System.out.println("EnumSet中的元素：" + week);
        week.removeAll(EnumSet.range(WeekDay.FRI, WeekDay.SAT));
        System.out.println("EnumSet中的元素：" + week);
	}

}
