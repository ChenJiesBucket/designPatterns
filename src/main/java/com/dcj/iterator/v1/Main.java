package com.dcj.iterator.v1;

public class Main {
    public static void main(String[] args) {
        Collections_<String> list = new LinkList_<String>();
        for(int i=0;i<5;i++){
            list.add("str--"+i);
        }
        Iterator_<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
