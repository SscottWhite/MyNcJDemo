package com.example.designmode.factory.abstractfactory;

import com.example.designmode.factory.instance.ipad.Ipad;
import com.example.designmode.factory.instance.pc.PC;
import com.example.designmode.factory.instance.phone.Phone;

//总工厂来分配
public interface Factory {
	Phone createPhone();
	Ipad createPad();
	PC createPC();
}
