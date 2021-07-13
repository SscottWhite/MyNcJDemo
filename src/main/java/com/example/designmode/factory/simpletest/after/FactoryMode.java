package com.example.designmode.factory.simpletest.after;

import com.example.designmode.factory.simpletest.AndroidTest;
import com.example.designmode.factory.simpletest.IosPhone;
import com.example.designmode.factory.simpletest.Phone;

/**
 * 简单工厂模式
 * @author KJS_352
 *
 */
public class FactoryMode {
    public static Phone createPhone(String type) {
        Phone phone = null;
        if ("huawei".equals(type)) {
            phone = new IosPhone();
        } else if ("xiaomi".equals(type)) {
            phone = new AndroidTest();
        } else {
            System.out.println("暂不支持");
        }
        return phone;
    }
}