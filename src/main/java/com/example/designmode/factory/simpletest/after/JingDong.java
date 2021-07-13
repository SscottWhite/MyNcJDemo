package com.example.designmode.factory.simpletest.after;

import com.example.designmode.factory.simpletest.Phone;

public class JingDong {
	public void order(String type) {
		Phone phone = FactoryMode.createPhone(type);
		if(phone != null) {
			phone.play();
		}
	}
}
