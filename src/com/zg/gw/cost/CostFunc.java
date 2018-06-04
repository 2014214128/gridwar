package com.zg.gw.cost;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.Score;

import java.util.List;

/**
 * Created by zhengguo on 2018/5/23.
 */
public interface CostFunc {
    long calCost(Node tree,List<Score> s);
}
