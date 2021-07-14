package com.example.designmode.singleinstance;

import com.example.designmode.factory.instance.phone.IosPhone;
import com.example.designmode.singleinstance.model.SingleModel;

public class Test {
	public static void main(String[] args) {
		SingleModel sm = SingleModel.getInstance();
		SingleModel sm2 = SingleModel.getInstance();
		
		IosPhone is = new IosPhone();
		IosPhone is2 = new IosPhone();
		
		System.out.println(sm == sm2);
		System.out.println(is == is2);
		
		sm.test();
		sm2.test();
		sm.test();
		sm2.test();
	}
}
