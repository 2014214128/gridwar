package com.zg.gw.function.impl;

import com.zg.gw.cost.impl.OneNormCostFunc;
import com.zg.gw.entity.Node;
import com.zg.gw.entity.RankScore;
import com.zg.gw.entity.Score;
import com.zg.gw.function.RankFunction;

import java.util.*;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class RankFunc implements RankFunction{

    public static List<Score> buildhiddenset() {
        List<Score> rows = new ArrayList<>();
        int x,y;
        for (int i=0; i<200; i++) {
            Score score = new Score();
            x = i+3;
            y = 3*i-1;
            score.setX(x);
            score.setY(y);
            score.setScore(x*y);
            rows.add(score);
        }

        return rows;
    }

    public  List<RankScore> getRankFunction(List<Node> population) {
        List<RankScore> scores = new ArrayList<>();
        for (int i=0; i<population.size(); i++) {
            RankScore rankScore = new RankScore();
            rankScore.setScore(new OneNormCostFunc().calCost(population.get(i), buildhiddenset()));
            rankScore.setT(population.get(i));
            scores.add(rankScore);
        }
        Collections.sort(scores, new Comparator<RankScore>() {
            @Override
            public int compare(RankScore o1, RankScore o2) {
                if (o1.getScore() > o2.getScore()) return 1;
                else if (o1.getScore() == o2.getScore()) return 0;
                else return -1;
            }
        });
        return scores;
    }
}
