package com.dcj.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;
//局限 生成的是子类 如果tank 是final 仍然可以生成 底层被改这些  cglib 底层也是sam
//这也是面向切面编程
interface  Moveable{
    public void move();
}

class Tank {

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
class TankTimestamp implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        Long start = System.currentTimeMillis();
        Object obj= methodProxy.invokeSuper(o,objects);//注意与proxy的不同！
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        return obj;
    }

    private Moveable m;
    public TankTimestamp(){

    }


}
public class cglib {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TankTimestamp());
        Tank t= (Tank)enhancer.create();
        t.move();
    }
}
