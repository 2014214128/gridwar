package com.zg.gw.environment;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.RankScore;
import com.zg.gw.function.RankFunction;
import com.zg.gw.function.impl.RankFunc;
import com.zg.gw.ga.Crossover;
import com.zg.gw.ga.Mutate;
import com.zg.gw.tree.RandomTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class Environment {
    public static List<RankScore> evolve(List<Node> p,int pc, int popsize, RankFunction rankFunc) {
        return evolve(p, pc, popsize, rankFunc, 500);
    }

    public static List<RankScore> evolve(List<Node> p,int pc, int popsize, RankFunction rankFunc, int maxgen) {
        return evolve(p, pc, popsize, rankFunc, maxgen, 0.1);
    }

    public static List<RankScore> evolve(List<Node> p,int pc, int popsize, RankFunction rankFunc, int maxgen, double mutationrate) {
        return evolve(p, pc, popsize, rankFunc, maxgen, mutationrate, 0.4);
    }

    public static List<RankScore> evolve(List<Node> p,int pc, int popsize, RankFunction rankFunc, int maxgen, double mutationrate, double breedingrate) {
        return evolve(p, pc, popsize, rankFunc, maxgen, mutationrate, breedingrate, 0.7);
    }

    public static List<RankScore> evolve(List<Node> p,int pc, int popsize, RankFunction rankFunc, int maxgen, double mutationrate, double breedingrate, double pexp) {
        return evolve(p, pc, popsize, rankFunc, maxgen, mutationrate, breedingrate, pexp, 0.05);
    }

    public static List<RankScore> evolve(List<Node> p, int pc, int popsize, RankFunction rankFunc, int maxgen, double mutationrate, double breedingrate, double pexp, double pnew) {
        List<Node> population = null;
        if (p == null) {
            population = new ArrayList<>();
            for (int i = 0; i < popsize; i++) {
                population.add(RandomTree.makeRandomTree(pc));
            }
        } else {
            population = p;
        }
        List<RankScore> scores = new ArrayList<>();
        List<Node> newpop = null;
        for (int i = 0; i < maxgen; i++) {
            scores = rankFunc.getRankFunction(population);
            System.out.println(scores.get(0).getScore());
            if (scores.get(0).getScore() == 0) break;
            newpop = new ArrayList<>();
            newpop.add(scores.get(0).getT());
            newpop.add(scores.get(1).getT());
            while (newpop.size() < popsize) {
                if (Math.random() > pnew) {
                    int temp1 = selectIndex(pexp);
                    int temp2 = selectIndex(pexp);
                    int index1 = temp1 <= 1 ? temp1+2: temp1;
                    int index2 = temp2 <= 1 ? temp2+2: temp2;
                    newpop.add(Mutate.mutate(Crossover.crossover(scores.get(index1).getT(), scores.get(index2).getT(), breedingrate), pc, mutationrate));
                } else {
                    newpop.add(RandomTree.makeRandomTree(pc));
                }
            }
            population = newpop;
        }
        scores.get(0).getT().display(2);
        return scores;

    }

    private static int selectIndex(double pexp) {
        return (int) (Math.log(Math.random()) / Math.log(pexp));
    }
}
