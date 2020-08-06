package com.dcj.decorated;
//创建扩展了 ShapeDecorator 类的实体装饰类。
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shapeDecorator.draw();
        this.setRedBorder(shapeDecorator);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
