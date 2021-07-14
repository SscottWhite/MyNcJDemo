package com.example.designmode.factory.simpletest.after;

import com.example.designmode.factory.instance.phone.AndroidPhone;
import com.example.designmode.factory.instance.phone.IosPhone;
import com.example.designmode.factory.instance.phone.Phone;

/**
 * 简单工厂模式
 * @author KJS_352
 * 就是实例交给工厂来造, 修改这个地方就能全受用
 */
public class FactoryMode {
    public static Phone createPhone(String type) {
        Phone phone = null;
        if ("huawei".equals(type)) {
            phone = new IosPhone();
        } else if ("xiaomi".equals(type)) {
            phone = new AndroidPhone();
        } else {
            System.out.println("暂不支持");
        }
        return phone;
    }
}