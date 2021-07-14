package com.example.designmode.factory.abstractfactory.impl;

import com.example.designmode.factory.abstractfactory.Factory;
import com.example.designmode.factory.instance.ipad.IosPad;
import com.example.designmode.factory.instance.ipad.Ipad;
import com.example.designmode.factory.instance.pc.IosPC;
import com.example.designmode.factory.instance.pc.PC;
import com.example.designmode.factory.instance.phone.IosPhone;
import com.example.designmode.factory.instance.phone.Phone;

public  class IosFactory implements Factory {
	@Override
	public Phone createPhone() {
		return new IosPhone();
	}

	@Override
	public Ipad createPad() {
		return new IosPad();
	}

	@Override
	public PC createPC() {
		return new IosPC();
	}

}
