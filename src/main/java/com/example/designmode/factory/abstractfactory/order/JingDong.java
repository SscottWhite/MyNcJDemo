package com.example.designmode.factory.abstractfactory.order;

import com.example.designmode.factory.abstractfactory.Factory;
import com.example.designmode.factory.abstractfactory.impl.AndroidFactory;
import com.example.designmode.factory.abstractfactory.impl.IosFactory;
import com.example.designmode.factory.instance.ipad.Ipad;
import com.example.designmode.factory.instance.pc.PC;
import com.example.designmode.factory.instance.phone.Phone;

public class JingDong {
	
	public void orderIos() {
		Factory factory = new IosFactory();
		Phone phone = factory.createPhone();
		phone.play();
		Ipad ipad = factory.createPad();
		ipad.play();
		PC pc = factory.createPC();
		pc.play();
	}
	
	public void orderAndroid() {
		Factory factory = new AndroidFactory();
		Phone phone = factory.createPhone();
		phone.play();
		Ipad ipad = factory.createPad();
		ipad.play();
		PC pc = factory.createPC();
		pc.play();
	}
}
