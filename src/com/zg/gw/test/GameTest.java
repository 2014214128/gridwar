package com.zg.gw.test;

import com.zg.gw.entity.Node;
import com.zg.gw.game.GridGame;
import com.zg.gw.tree.RandomTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengguo on 2018/5/24.
 */
public class GameTest {
    public static void main(String[] args) {
        Node p1 = RandomTree.makeRandomTree(5);
        Node p2 = RandomTree.makeRandomTree(5);
        List<Node> p = new ArrayList<>();
        p.add(p1);
        p.add(p2);
//        System.out.println(GridGame.gridGame(p));

    }
}
