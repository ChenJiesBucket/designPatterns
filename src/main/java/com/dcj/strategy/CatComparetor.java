package com.dcj.strategy;

public class CatComparetor implements  Comparetor<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
       return  o1.getHeight()-o2.getHeight()==0 ? 0 : o1.getHeight()-o2.getHeight();
    }
}
