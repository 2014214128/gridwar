package com.zg.gw.entity.impl;

import com.zg.gw.entity.Node;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class ConstNode implements Node{
    private int v;

    public ConstNode(int v) {
        this.v = v;
    }

    public int evaluate(int[] inp) {
        return this.v;
    }

    @Override
    public void display(int indent) {
        String str = "";
        for (int i=0; i<indent; i++) str += ' ';
        System.out.println(String.format("%s%d", str, this.v));
    }


    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public Object clone() {
        Node result = null;
        try {
            result = (Node) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
