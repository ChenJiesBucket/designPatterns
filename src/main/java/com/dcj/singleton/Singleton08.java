package com.dcj.singleton;

/**
 *effectjava
 * 枚举单示例
 * 不仅线程安全而且可以反序列化 序列化是通过enum不能有构造方法 是指abstuctclass
 */
public enum Singleton08 {
   INSTANCE;

    public static void main(String[] args) {
        Singleton08 s1 = Singleton08.INSTANCE;
        Singleton08 s2 = Singleton08.INSTANCE;
        System.out.println(s1==s2);

    }

}
