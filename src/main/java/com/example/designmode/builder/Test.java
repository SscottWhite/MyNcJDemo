package com.example.designmode.builder;

public class Test {
	public static void main(String[] args) {
		PersonDesign personDesign = new PersonDesign();
		Person ps = personDesign.getInstance(new PersonGet());
		//通过子类里的功能来返回person初始对象, 然后用getInstance来完善内容, 完成对对象一步一步的创建
		System.out.println(ps.getAge());
	}
}
