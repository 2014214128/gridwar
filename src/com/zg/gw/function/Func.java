package com.zg.gw.function;

/**
 * Created by zhengguo on 2018/5/23.
 */
public interface Func extends Cloneable {
    int cal(int[] l);
    Object clone();
}
