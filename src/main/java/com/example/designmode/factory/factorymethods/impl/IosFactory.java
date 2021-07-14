package com.example.designmode.factory.factorymethods.impl;

import com.example.designmode.factory.factorymethods.PhoneFactory;
import com.example.designmode.factory.instance.phone.IosPhone;
import com.example.designmode.factory.instance.phone.Phone;

public class IosFactory implements PhoneFactory{

	@Override
	public Phone create() {
		return new IosPhone();
	}

}
