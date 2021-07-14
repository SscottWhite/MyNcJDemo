package com.example.designmode.factory.simpletest.before;

import com.example.designmode.factory.instance.phone.AndroidPhone;
import com.example.designmode.factory.instance.phone.IosPhone;
import com.example.designmode.factory.instance.phone.Phone;

public class JingDong {
    public void order(String type) {
        Phone phone = null;
        if ("huawei".equals(type)) {
            phone = new IosPhone();
            phone.play();
        } else if ("xiaomi".equals(type)) {
            phone = new AndroidPhone();
            phone.play();
        } else {
            System.out.println("暂不支持");
        }
    }
}