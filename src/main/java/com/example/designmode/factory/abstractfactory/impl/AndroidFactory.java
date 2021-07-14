package com.example.designmode.factory.abstractfactory.impl;

import com.example.designmode.factory.abstractfactory.Factory;
import com.example.designmode.factory.instance.ipad.AndroidPad;
import com.example.designmode.factory.instance.ipad.Ipad;
import com.example.designmode.factory.instance.pc.AndroidPC;
import com.example.designmode.factory.instance.pc.PC;
import com.example.designmode.factory.instance.phone.AndroidPhone;
import com.example.designmode.factory.instance.phone.Phone;

public class AndroidFactory implements Factory {

	@Override
	public Phone createPhone() {
		return new AndroidPhone();
	}

	@Override
	public Ipad createPad() {
		return new AndroidPad();
	}

	@Override
	public PC createPC() {
		return new AndroidPC();
	}

}
