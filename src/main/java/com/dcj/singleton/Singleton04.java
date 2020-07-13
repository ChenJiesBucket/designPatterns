package com.dcj.singleton;


/**
 * lazyloading
 * 懒汉模式
 * 在调用时判断进行生成danshili对象
 * 加锁 存在线程不安全因素
 * 但 效率降低
 */
public class Singleton04 {
    //不能加final 因为还没有进行初始化
    private static Singleton04 INSTANCE;

    private Singleton04(){};

    public  static synchronized Singleton04 getInstance(){
        if(INSTANCE==null){
            try {
                Thread.sleep(2);
            }catch(Exception e){
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
        Singleton04 s1 = Singleton04.getInstance();
        Singleton04 s3 = new Singleton04();
        Singleton04 s2 = Singleton04.getInstance();
        System.out.println(s1==s2);
    }

}
