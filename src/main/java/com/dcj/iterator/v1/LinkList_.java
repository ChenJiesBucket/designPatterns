package com.dcj.iterator.v1;

public class LinkList_<E> implements Collections_<E> {
    private int index =0;
    private  Node head = null;
    private  Node tail = null;
    @Override
    public void add(Object o) {
        Node node = new Node(o);
        node.next = null;
        if(head == null){
            head= node;
            //head.next = tail;
            tail = node;
        }
        /*声明此时尾部的下一个元素地址为这个*/
        tail.next = node;
        /*给尾部赋值*/
        tail = node;
        index++;
    }
    @Override
    public int size() {
        return index;
    }


    @Override
    public Iterator_ iterator() {
        return new LinkListIterator();
    }


    private  class LinkListIterator<E> implements  Iterator_<E>{
        private Node currentNode = head;
        @Override
        public Boolean hasNext() {
            if(null== currentNode) return  false;
            return true;
        }

        @Override
        public E next() {
            E o = (E)currentNode.o;
            currentNode = currentNode.next;
            return o;
        }
    }


}

class Node{
    Object o;
    Node next;

    public Node(Object o) {
        this.o = o;
    }
}