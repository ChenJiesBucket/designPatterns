package com.dcj.state.v1;
//状态模式 应用 状态机 多线程
public class Main {
    public static void main(String[] args) {
        CarState c = new OpenCar();
        c.open();
    }
}


class OpenCar extends  CarState{

    CarState carState;
    @Override
    public void open() {
        //党车开门的时候 只能关门
        System.out.println("close");
    }

    @Override
    public void close() {
        System.out.println("open run stop");
    }

    @Override
    public void run() {
        System.out.println("stop");
    }

    @Override
    public void stop() {
        System.out.println("run open");
    }


}

class ClosCar extends  CarState{
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
