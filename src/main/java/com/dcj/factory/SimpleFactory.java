package com.dcj.factory;
//简单工厂模式 拓展行不太好 应该对每一种产品做工厂 对产品维度拓展比较方便
public class SimpleFactory {
    public Car createCar(){
        return new Car();
    }
    public Broom createBroom(){
        return new Broom();
    }
}


