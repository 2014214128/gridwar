package com.zg.gw.function.impl;

import com.zg.gw.function.Func;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class IfFunc implements Func, Cloneable {
    @Override
    public int cal(int[] l) {
        if (l[0] > 0) return l[1];
        else return l[2];
    }

    @Override
    public Object clone() {
        Func f = null;
        try {
            f = (Func) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return f;
    }
}
