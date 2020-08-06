package com.dcj.proxy.v02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 动态代理模式   核心asm java动态语言 -asm（更改代码） 反射是只能读取  基于jvm运行 所以只要能形成class文件形式的语言 比如scale kotin都可以在jvm运行和java一起
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

class TankTimestamp implements Moveable {
    private Moveable m;
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

class TankLogs implements InvocationHandler {
    private Moveable m;
    public TankLogs() {

    }

    public TankLogs(Moveable m) {
        this.m = m;
    }

    public void move() {
        System.out.println("startMoveing....");
        m.move();
        System.out.println("stopMoveing!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("methodName:"+method.getName());
        Object o = method.invoke(m,args);
        //m.move();
        return o;
    }
}

public class TankMovev2 {
    public static void main(String[] args) {
        Tank tank = new Tank();
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Moveable m = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(),//获得被代理的classLoader
                new Class[]{Moveable.class},// 被代理class 需要的实现接口 JDK的代理的局限：必须要有实现的接口
                new TankLogs(tank) //在被代理class 被调用时需要执行的方法
                  );
        m.move();//指定的是第三个参数指定的move方法

    }
}

