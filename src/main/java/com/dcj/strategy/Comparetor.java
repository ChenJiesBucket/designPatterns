package com.dcj.strategy;
//用于比较不同的值
//@FunctionalInterface 声明一个函数接口
public interface Comparetor<T> {
    int compare(T o1 ,T o2);
}
