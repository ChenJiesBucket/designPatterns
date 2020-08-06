package com.dcj;

import java.util.ArrayList;
import java.util.List;

//复杂模式 - 树形结构
abstract class Node{
    abstract public void p();
}
class LeafNode extends  Node{
    private String context;

    public LeafNode(String context) {
        this.context = context;
    }

    @Override
    public void p() {
        System.out.println(context);
    }
}
class BranchNode extends Node{
    private  String name;
    private  List<Node> nodes = new ArrayList<Node>();

    public BranchNode(String name) {
        this.name = name;
    }

    public void add(Node node){
        nodes.add(node);
    }
    public List<Node> getNodes(){
        return nodes;
    }
    @Override
    public void p() {
        System.out.println(name);
    }
}
public class Composite {
    public static void main(String[] args) {
        BranchNode bn = new BranchNode("root");
        BranchNode bchild1 = new BranchNode("branch1");
        BranchNode bchild2 = new BranchNode("branch2");
        bn.add(bchild1);
        bn.add(bchild2);
        LeafNode ln1 = new LeafNode("leaf1");
        LeafNode ln2 = new LeafNode("leaf2");
        bchild1.add(ln1);
        bchild1.add(ln2);
        LeafNode ln3 = new LeafNode("leaf3");
        LeafNode ln4 = new LeafNode("leaf4");
        bchild2.add(ln3);
        bchild2.add(ln4);
        printTree(bn,0);
    }

    static void printTree(Node node,int deepth){
        System.out.println("|");
        String l ="--";
        for(int i=0;i<=deepth;i++){
            l+=l;
        }
        System.out.print(l);
        node.p();
        if(node instanceof  BranchNode){
            deepth++;
            BranchNode bn = (BranchNode)node;
            for(Node cnode : bn.getNodes()){
                printTree(cnode,deepth);
            }
        }
    }
}
