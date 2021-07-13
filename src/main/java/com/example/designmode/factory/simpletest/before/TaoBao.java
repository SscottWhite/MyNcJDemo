package com.example.designmode.factory.simpletest.before;

import com.example.designmode.factory.simpletest.AndroidTest;
import com.example.designmode.factory.simpletest.IosPhone;
import com.example.designmode.factory.simpletest.Phone;

public class TaoBao {
    public void order(String type) {
        Phone phone = null;
        if ("huawei".equals(type)) {
            phone = new IosPhone();
            phone.play();
        } else if ("xiaomi".equals(type)) {
            phone = new AndroidTest();
            phone.play();
        } else {
            System.out.println("暂不支持");
        }
    }
}