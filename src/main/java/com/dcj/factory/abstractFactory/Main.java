package com.dcj.factory.abstractFactory;

public class Main {
    public static void main(String[] args) {
        //注意：用抽象类接收实体对象    调用父类的公共方法实现对不同子类的调用  对产品一族进行拓展方便

        /**
         * request 1： 为什么在简单工厂模式用的是interface（接口） 而在抽象工厂用的是抽象类呢？
         * answer: 像Moveable 是一种动作 用接口可以互相实现 ，而Food是一种分类 形容词用接口 名词用抽象类
         */
        AbstractFactory m = new ModelFactory();
        m.createFood().printName();
        m.createVehicle().go();
        m.createWeapon().useWeapon();

        System.out.println("====================");
        AbstractFactory magic = new MegicFactory();
        magic.createFood().printName();
        magic.createVehicle().go();
        magic.createWeapon().useWeapon();

    }
}
