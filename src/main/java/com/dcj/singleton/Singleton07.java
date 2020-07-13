package com.dcj.singleton;


/**
 *  静态内部类方式  通过jvm保证线程安全,必须为私有方法
 *  在加载外部类时只有调用内部类才会初始化内部类
 */
public class Singleton07 {
    //不能加final 因为还没有进行初始化
    private static  Singleton07 INSTANCE;

    private Singleton07(){};

    //内部类
    private static class singleton {
        //必须用final
        private static final  Singleton07 INSTANCE =  new Singleton07();
    }

    public static Singleton07 getInstance(){
        return singleton.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton07.getInstance().hashCode());
            }).start();
        }
        Singleton07 s1 = Singleton07.getInstance();
        Singleton07 s3 = new Singleton07();
        Singleton07 s2 = Singleton07.getInstance();
        System.out.println(s1==s2);
    }

}
