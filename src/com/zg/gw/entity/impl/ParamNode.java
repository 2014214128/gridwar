package com.zg.gw.entity.impl;

import com.zg.gw.entity.Node;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class ParamNode implements Node{
    private int idx;

    public ParamNode(int idx) {
        this.idx = idx;
    }

    public int evaluate(int[] inp) {
        return inp[this.idx];
    }

    @Override
    public void display(int indent) {
        String str = "";
        for (int i=0; i<indent; i++) str += ' ';
        System.out.println(String.format("%sp%d", str, this.idx));
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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
