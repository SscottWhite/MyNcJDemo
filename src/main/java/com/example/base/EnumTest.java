package com.example.base;

import java.util.EnumSet;

public class EnumTest {
	public static void main(String[] args) {
		//枚举集合测试	
		EnumSet<WeekDayEnum> week = EnumSet.noneOf(WeekDayEnum.class);
        week.add(WeekDayEnum.MON);
        System.out.println("EnumSet中的元素：" + week);
        week.remove(WeekDayEnum.MON);
        System.out.println("EnumSet中的元素：" + week);
        week.addAll(EnumSet.complementOf(week));
        System.out.println("EnumSet中的元素：" + week);
        week.removeAll(EnumSet.range(WeekDayEnum.FRI, WeekDayEnum.SAT));
        System.out.println("EnumSet中的元素：" + week);
	}

}
