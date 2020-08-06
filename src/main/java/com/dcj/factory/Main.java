package com.dcj.factory;

public class Main {
    public static void main(String[] args) {
        Moveable m = new SimpleFactory().createBroom();
        m.go();
    }
}
