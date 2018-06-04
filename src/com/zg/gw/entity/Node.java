package com.zg.gw.entity;

/**
 * Created by Administrator on 2018/5/23.
 */
public interface Node extends Cloneable{
    int evaluate(int[] inp);
    void display(int indent);
    Object clone();
}
