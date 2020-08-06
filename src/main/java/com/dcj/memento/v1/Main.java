package com.dcj.memento.v1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        memento  m = new memento();
        m.addList("1").addList("2").addList("3").addList("4").addList("5").addList("6").addList("7").addList("8").addList("9").addList("10");
        mementoChild child1 = new mementoChild("zhangsan",10);
        m.addChild(child1).addChild(child1).addChild(child1).addChild(child1).addChild(child1).addChild(child1);
        //存取
        try {
            File f= new File("C:/data.data");
            if(!f.exists()) f.createNewFile();
            //报java.io.NotSerializableException: 原因 本方法 或内部方法没有实现序列化，解决方法 如果不是重要的部分 可以使用transient 否则实现序列化
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(m);
            oos.flush();
            oos.close();
            m=null;
            //读回来
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
             m = (memento)ois.readObject();
            System.out.println(m);



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class memento implements Serializable {
    List<String> list = new ArrayList<>();
   /* transient*/ List<mementoChild> child = new ArrayList<mementoChild>();

    public memento() {
    }

    public memento(List<String> list, List<mementoChild> child) {
        this.list = list;
        this.child = child;
    }

    public List<String> getList() {
        return list;
    }

    public memento addList(String str) {
        this.list.add(str);
        return this;
    }

    public List<mementoChild> getChild() {
        return child;
    }

    public memento addChild(mementoChild child) {
        this.child.add(child);
        return this;
    }

    @Override
    public String toString() {
        return "memento{" +
                "list=" + list +
                ", child=" + child +
                '}';
    }
}
class mementoChild implements Serializable  {
    String name;
    int age;

    public mementoChild() {
    }

    public mementoChild(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "mementoChild{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
