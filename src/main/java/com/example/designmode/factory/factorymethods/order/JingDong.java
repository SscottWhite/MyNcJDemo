package com.example.designmode.factory.factorymethods.order;

import com.example.designmode.factory.factorymethods.PhoneFactory;
import com.example.designmode.factory.factorymethods.impl.AndroidFactory;
import com.example.designmode.factory.factorymethods.impl.IosFactory;
import com.example.designmode.factory.instance.phone.Phone;

public class JingDong {
	public void orderIOS() {
		PhoneFactory phoneFactory = new IosFactory();
		Phone phone = phoneFactory.create();
		phone.play();
	}
	
	public void orderAndroid() {
		PhoneFactory phoneFactory = new AndroidFactory();
		Phone phone = phoneFactory.create();
		phone.play();
	}
}
