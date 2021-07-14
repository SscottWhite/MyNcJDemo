package com.example.designmode.factory.factorymethods;

import com.example.designmode.factory.instance.phone.Phone;

//工厂方法模式 将方法用接口形式统一
public interface PhoneFactory {
	Phone create();
}
