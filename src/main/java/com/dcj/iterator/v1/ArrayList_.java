package com.dcj.iterator.v1;

public class ArrayList_<E> implements  Collections_<E> {
    private E[] objects = (E[])new Object[10];

    private int index = 0;

   @Override
    public void add(E o){
        if(index == objects.length){
            E[] newObject = (E[])new Object[objects.length*2];
            System.arraycopy(objects,0,newObject,0,objects.length);
            objects = newObject;
        }
        objects[index] = o;
        index++;
    }


    @Override
    public  int size(){
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }


    private  class ArrayListIterator implements  Iterator_{
       private  int currentIteratorIndex = 0;
        @Override
        public Boolean hasNext() {
            if(currentIteratorIndex>=index)return false;
            return true;
        }

        @Override
        public E next() {
            E o = objects[currentIteratorIndex];
            currentIteratorIndex++;
            return o;
        }
    }
}
