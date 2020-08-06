package com.dcj.factory.abstractFactory;

//抽象工厂  可以产生一系列方法 注意返回值为父类方法
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
