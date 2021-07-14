package com.example.designmode.factory.abstractfactory;

import com.example.designmode.factory.instance.ipad.Ipad;
import com.example.designmode.factory.instance.pc.PC;
import com.example.designmode.factory.instance.phone.Phone;

//总工厂来分配
//抽象接口模式就是把接口类 再统一在factory接口中
//像是吞并了前两个模式
public interface Factory {
	Phone createPhone();
	Ipad createPad();
	PC createPC();
}
