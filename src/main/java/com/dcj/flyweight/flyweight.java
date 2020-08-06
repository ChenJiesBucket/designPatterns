package com.dcj.flyweight;
//享元模式： 共同使用同一个变量
//String 就是一个典型案例 ： String 相同字符串使用常量池相同的变量
public class flyweight {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1==s3);//new 引用变量地址不相同
        System.out.println(s1== s3.intern());//s3转换为常量相同
    }
}
