package com.dcj.strategy;

public class Cat implements Comparable<Cat>{
    private  int height;
    private  int weight;

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public Cat() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
