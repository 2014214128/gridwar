package com.zg.gw.function;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.RankScore;

import java.util.List;

/**
 * Created by zhengguo on 2018/5/24.
 */
public interface RankFunction {
    List<RankScore> getRankFunction(List<Node> population);
}
