package com.zg.gw.function.impl;

import com.zg.gw.entity.Location;
import com.zg.gw.entity.Node;
import com.zg.gw.entity.RankScore;
import com.zg.gw.function.RankFunction;
import com.zg.gw.game.GridGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhengguo on 2018/5/24.
 */
public class TournamentFunc implements RankFunction {

    public  List<RankScore> getRankFunction(List<Node> p) {
        int[] losses = new int[p.size()];
        List<RankScore> scores = new ArrayList<>();
        for (int i=0; i<p.size(); i++) {
            for (int j=0; j<p.size(); j++) {
                if ( i==j ) {
                    continue;
                }
                List<Node> competitors = new ArrayList<>();
                competitors.add(p.get(i));
                competitors.add(p.get(j));

                int [] max = {3, 3};
                int [] lastmove = {-1, -1};
                List<Location> location = new ArrayList<>();
                location.add(new Location(((int)(Math.random()*(max[0]))%4),((int)(Math.random()*(max[0]))%4)));
                location.add(new Location((location.get(0).getX()+2)%4, (location.get(0).getY()+2)%4));

                int winner = -1;
                for (int k=0; k<50; k++) {
                    winner = GridGame.gridGame(location, lastmove, competitors);
                    if (winner != -1) {
                        break;
                    }
                }
                
                
                if (winner == 0) {
                    losses[j] += 2;
                } else if (winner == 1) {
                    losses[i] += 2;
                } else {
                    losses[i] += 1;
                    losses[j] += 1;
                }
            }
        }
        RankScore rankScore = null;
        for (int i=0; i<p.size(); i++) {
            rankScore = new RankScore();
            rankScore.setT(p.get(i));
            rankScore.setScore(losses[i]);
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
