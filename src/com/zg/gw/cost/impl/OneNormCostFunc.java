package com.zg.gw.cost.impl;

import com.zg.gw.cost.CostFunc;
import com.zg.gw.entity.Node;
import com.zg.gw.entity.Score;

import java.util.List;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class OneNormCostFunc implements CostFunc {
    @Override
    public long calCost(Node tree, List<Score> s) {
        long dif = 0;
        long v = 0;
        for (Score data: s) {
            v = tree.evaluate(new int[]{data.getX(), data.getY()});
            dif += Math.abs(v - data.getScore());
        }
        return dif;
    }
}
