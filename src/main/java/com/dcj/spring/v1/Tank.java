package com.dcj.spring.v1;

import java.util.Random;

public class Tank{

    public void move() {
        System.out.println("wuwuwu....");
        Random r = new Random();
        try {
            Thread.sleep( r.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}