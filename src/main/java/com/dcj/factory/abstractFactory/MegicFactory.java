package com.dcj.factory.abstractFactory;

public class MegicFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicWands();
    }
}
