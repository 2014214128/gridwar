package com.zg.gw.function.impl;

import com.zg.gw.function.Func;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class IsGreaterFunc implements Func, Cloneable {
    @Override
    public int cal(int[] l) {
        if (l[0] > l[1]) return 1;
        else return 0;
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
