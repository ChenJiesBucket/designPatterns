package com.dcj.factory;

public class CarFactory {
    public Car createCar(){
        System.out.println("create Car Success!");
        return new Car();
    }
}
