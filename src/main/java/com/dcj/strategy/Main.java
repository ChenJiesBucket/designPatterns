package com.dcj.strategy;
//策略模式封装的是做一件事的不同方式
public class Main {
    public static void main(String[] args) {
        Cat[] c = {new Cat(5,3),new Cat(3,2),new Cat(4,1)};
        Sorter<Cat> sorterCat = new Sorter<Cat>();
        sorterCat.sort(c,new CatComparetor());
        System.out.println("===根据身高排序===");
        for(Cat cat : c){
            System.out.println(cat);
        }

        System.out.println("===根据体重排序===");
        sorterCat.sort(c, new Comparetor<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getWeight()-o2.getWeight()==0?0:o1.getWeight()-o2.getWeight();
            }
        });
        for(Cat cat : c){
            System.out.println(cat);
        }
        //lambda对于方法里有一个方法（简称单函数表达式）的适用
        System.out.println("===根据体重排序labda===");
        sorterCat.sort(c,(o1,o2)->{
            return o1.getWeight()-o2.getWeight()==0?0:o1.getWeight()-o2.getWeight();
        });
        for(Cat cat : c){
            System.out.println(cat);
        }
    }
}
