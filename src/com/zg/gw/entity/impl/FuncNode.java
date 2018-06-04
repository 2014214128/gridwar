package com.zg.gw.entity.impl;

import com.zg.gw.entity.Node;
import com.zg.gw.function.Func;
import com.zg.gw.tree.CopyTree;
import com.zg.gw.wapper.FunctionWapper;

import java.util.ArrayList;
import java.util.List;

import static com.zg.gw.tree.CopyTree.copyTree;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class FuncNode implements Node{

    private Func function;
    private String name;
    private List<Node> children;

    public FuncNode(FunctionWapper fw, List<Node> children) {
        this.function = fw.getFunction();
        this.name = fw.getName();
        this.children = children;
    }

    public int evaluate(int[] inp) {
        int n = this.children.size();
        int[] results = new int[n];
        for (int i = 0; i<n; i++) {
            results[i] = this.children.get(i).evaluate(inp);
        }
        return function.cal(results);
    }

    @Override
    public void display(int indent) {
        String str = "";
        for (int i=0; i<indent; i++) str += ' ';
        System.out.println(str+this.name);
        for (Node c: this.children) {
            c.display(indent + 2);
        }
    }

    public Func getFunction() {
        return function;
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setFunction(Func function) {
        this.function = function;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public Object clone(){
        FuncNode node = null;
        try {
            node = (FuncNode) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        node.setFunction((Func) this.getFunction().clone());
        node.children = new ArrayList<>();
        for (int i=0; i<this.getChildren().size(); i++) {
            node.children.add(copyTree((this.getChildren().get(i))));
        }
        return node;
    }
}
