package com.dcj.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TankTimestamp {
        private Tank m;
        public TankTimestamp(){

        }
        public TankTimestamp(Tank m) {
            this.m = m;
        }

        @Before("execution(void com.dcj.spring.v2.Tank.move())")
        public void before(){
            System.out.println("auto method start "+System.currentTimeMillis());
        }

        @After("execution(void com.dcj.spring.v2.Tank.move())")
        public void after(){
            System.out.println("auto method stop "+System.currentTimeMillis());
        }


    public void move() {
            System.out.println("TankTimestamp start!");
            Long start = System.currentTimeMillis();
            m.move();
            Long end = System.currentTimeMillis();
            System.out.println(end-start);
        }
}
