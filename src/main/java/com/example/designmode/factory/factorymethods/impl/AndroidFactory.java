package com.example.designmode.factory.factorymethods.impl;

import com.example.designmode.factory.factorymethods.PhoneFactory;
import com.example.designmode.factory.instance.phone.AndroidPhone;
import com.example.designmode.factory.instance.phone.Phone;

public class AndroidFactory implements PhoneFactory{

	@Override
	public Phone create() {
		return new AndroidPhone();
	}

}
