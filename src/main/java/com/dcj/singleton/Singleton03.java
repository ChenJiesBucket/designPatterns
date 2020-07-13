package com.dcj.singleton;


/**
 * lazyloading
 * 懒汉模式
 * 在调用时判断进行生成danshili对象
 * 缺点 存在线程不安全因素
 */
public class Singleton03 {
    //不能加final 因为还没有进行初始化
    private static  Singleton03 INSTANCE;

    private Singleton03(){};

    public  static  Singleton03 getInstance(){
        if(INSTANCE==null){
            try {
                Thread.sleep(2);
            }catch(Exception e){
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
        Singleton03 s1 = Singleton03.getInstance();
        Singleton03 s3 = new Singleton03();
        Singleton03 s2 = Singleton03.getInstance();
        System.out.println(s1==s2);
    }

}
