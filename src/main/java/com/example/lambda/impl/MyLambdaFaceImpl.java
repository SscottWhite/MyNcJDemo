package com.example.lambda.impl;

import java.util.Optional;

import com.example.lambda.MyLambdaFace;
import com.example.lambda.MyLambdaFace2;
import com.example.service.FanXing;

public class MyLambdaFaceImpl {
	public static void main(String[] args) {
		MyLambdaFaceImpl faceImple = new MyLambdaFaceImpl();
		
		MyLambdaFace face = new MyLambdaFace() {
			@Override
			public void getRun(String str) {
				System.out.println("face");
			}
		};
		
		MyLambdaFace face2 = (tt) -> {System.out.println("face2");};
		
		MyLambdaFace face3 = tt -> System.out.println("face2");
		
		//faceImpl4.face4("tsetface",String -> {System.out.println(String)});
		faceImple.face4("tsetfase",System.out::println);//相当于利用lambda简单重写了方法
		
		//在省去重写部分的参数, 也就是着重 重写方法的参数和返回值要和接口相同
		//记住是引用的方法返回值和接口的返回值相同, 应用了重写的概念, 实现的最终就是fase5方法
		MyLambdaFace2 face22 = new FanXing()::face5;  // => String -> {new Fanxing().face5(String)}
		System.out.println(face22.run("test22"));
	}
	
	
	public  void face4(String str ,MyLambdaFace face) {
		//
		Optional.ofNullable(str);
		
		face.getRun(str);
	}
}
