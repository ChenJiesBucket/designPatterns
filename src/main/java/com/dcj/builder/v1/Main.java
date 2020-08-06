package com.dcj.builder.v1;

public class Main {

    public static void main(String[] args) {
        //构建器   用来构建复杂对象   先创建最后用build构建起来
        Builder builder=  new Builder();
        builder.getfloor()
                .getsky()
                .build();
    }

}

class Builder{
    public  void build(){}
    public Builder getfloor(){
        return this;
    }
    public  Builder getsky(){
        return this;
    }
}
