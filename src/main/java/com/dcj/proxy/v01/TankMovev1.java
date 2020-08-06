package com.dcj.proxy.v01;

import java.util.Random;

/**
 * 静态代理模式
 * 想要计算坦克的运行时间
 * 如果原方法封装不能重写如何解决
 * 解决：通过代理模式 引用坦克基本类 在代理里面调用并计算时间
 * 如果想先计算时间 然后打一下日志 需要怎样做呢
 * 不推荐能用继承 会增加耦合，
 * 解决： 有一个共同基类,调用方法互相嵌套 实现代码嵌套顺序调用
 */
interface  Moveable{
    public void move();
}
class Tank implements Moveable {
    @Override
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
class TankTimestamp implements Moveable{
    private  Moveable m;
    public TankTimestamp(){

    }
    public TankTimestamp(Moveable m) {
        this.m = m;
    }
    @Override
    public void move() {
        Long start = System.currentTimeMillis();
        m.move();
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
class TankLogs implements Moveable{
    private  Moveable m;
    public TankLogs() {

    }

    public TankLogs(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("startMoveing....");
        m.move();
        System.out.println("stopMoveing!");
    }
}
public class TankMovev1 {
    public static void main(String[] args) {
        new TankLogs(
            new TankTimestamp(
                    new Tank()
            )
        ).move();

    }
}
