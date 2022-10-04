package com.example;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMD5 {
    public static void main(String[] args) {
        String md5="z3";
        Md5Hash md5Hash=new Md5Hash(md5);
        System.out.println("MD5加密后密码 = " + md5Hash);
    }
}
