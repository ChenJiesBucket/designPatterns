package com.dcj.decorated;
//创建实现了 Shape 接口的抽象装饰类。
public abstract class  ShapeDecorator implements Shape{
    //必须用prototype 子类能够访问
    protected  Shape shapeDecorator;

    public ShapeDecorator(Shape shape) {
        this.shapeDecorator = shape;
    }

    @Override
    public void draw() {
        this.shapeDecorator.draw();
    }
}
