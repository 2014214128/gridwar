package com.zg.gw.wapper;

import com.zg.gw.function.Func;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class FunctionWapper {

    private Func function;
    private int childCount;
    private String name;

    public FunctionWapper(Func function, int childCount, String name) {
        this.function = function;
        this.childCount = childCount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Func getFunction() {
        return function;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public void setFunction(Func function) {
        this.function = function;
    }
}

