package com.zg.gw.test;

import com.zg.gw.entity.Node;
import com.zg.gw.ga.Crossover;
import com.zg.gw.tree.RandomTree;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class MakeRandomTreeTest {
    public static void main(String[] args) {
        int[] l = {2, 4};
        Node random1 = RandomTree.makeRandomTree(2);
        Node random2 = RandomTree.makeRandomTree(2);
        random1.display(2);
        System.out.println(random1.evaluate(l));


        Node cross = Crossover.crossover(random1, random2);
        cross.display(2);
//        Node muttree = Mutate.mutate(random1, 2);
//        muttree.display(2);


    }
}
