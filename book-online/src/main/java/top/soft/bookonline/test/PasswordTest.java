package top.soft.bookonline.test;

import top.soft.bookonline.util.Md5Util;

public class PasswordTest {
    public static void main(String[] args) {
        String password="123456";
        String crypt = Md5Util.crypt(password);
        System.out.println(crypt);

    }
}
