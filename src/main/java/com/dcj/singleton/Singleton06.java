package com.dcj.singleton;


/**
 * lazyloading
 * 懒汉模式
 * 在调用时判断进行生成danshili对象
 * 加锁 存在线程不安全因素
 * 双重锁
 */
public class Singleton06 {
    //不能加final 因为还没有进行初始化
    private static volatile Singleton06 INSTANCE;// 本地化问题volatile JIT

    private Singleton06(){};

    public  static Singleton06 getInstance(){
        if(INSTANCE==null){
            synchronized(Singleton06.class){
                if(INSTANCE==null){
                    try {
                        Thread.sleep(1);
                    }catch(Exception e){
                    }
                    INSTANCE = new Singleton06();
                }
            };

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }
        Singleton06 s1 = Singleton06.getInstance();
        Singleton06 s3 = new Singleton06();
        Singleton06 s2 = Singleton06.getInstance();
        System.out.println(s1==s2);
    }

}
