package com.zg.gw.function.impl;

import com.zg.gw.function.Func;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class MulFunc implements Func, Cloneable {
    @Override
    public int cal(int[] l) {
        return l[0] * l[1];
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
