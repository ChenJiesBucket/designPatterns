package com.dcj.spring.v1;


public class TankTimestamp {
        private  Tank m;
        public TankTimestamp(){

        }
        public TankTimestamp(Tank m) {
            this.m = m;
        }
        public void before(){
            System.out.println("method start "+System.currentTimeMillis());
        }
        public void after(){
            System.out.println("method stop "+System.currentTimeMillis());
        }


    public void move() {
            System.out.println("TankTimestamp start!");
            Long start = System.currentTimeMillis();
            m.move();
            Long end = System.currentTimeMillis();
            System.out.println(end-start);
        }
}
