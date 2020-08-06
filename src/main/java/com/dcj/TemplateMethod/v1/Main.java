package com.dcj.TemplateMethod.v1;

public class Main {
    //模板方法 也叫钩子函数
    public static void main(String[] args) {
        template t = new demo();
        t.p();

    }
}
abstract class template{
    public void p(){
        method1();
        method2();
    }
    /*注意是抽象的*/
    abstract void method1();
    abstract void method2();
}
class demo extends template{

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}