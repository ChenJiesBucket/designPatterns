package com.dcj.observer;
//观察者模式
//当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，
// 则会自动通知依赖它的对象。观察者模式属于行为型模式。

import java.util.ArrayList;
import java.util.List;

//有两种实现方式  1种是 用while 等待若小孩哭了便创建对象调用 一种是直接耦合在被观察者里面
public class ObserverFirst {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}
class Child{
    private  Boolean cry;
    private List<Observer> observers = new ArrayList<Observer>();
    {
        observers.add(new Dad());
        observers.add(new Dog());
    }
    public Boolean isCry(){
        return this.cry;
    }
    public void wakeUp(){
        cry = true;
        Event<Child> event  = new Event<Child>(System.currentTimeMillis(),this);
        for(Observer o: observers){
            o.actionOnWakeUp(event);
        }
    }
}
class Event<T>{
    private Long timstamp;
    private T source;
    public Event() {}
    public Event(Long timstamp, T source) {
        this.timstamp = timstamp;
        this.source = source;
    }

    public  <T> T  getSource(){
        return (T) source;
    }

    public Long getTimstamp() {
        return timstamp;
    }
}
class Dad implements Observer {
    @Override
    public void actionOnWakeUp(Event<Child> event) {
        System.out.println("dad wuwuwuuw");
        System.out.println(event.getSource().toString());
    }
}
class Dog implements Observer{
    @Override
    public void actionOnWakeUp(Event<Child> event) {
        System.out.println("dog wangwang");
        System.out.println(event.getTimstamp());
    }
}
