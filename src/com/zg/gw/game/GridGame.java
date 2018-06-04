package com.zg.gw.game;

import com.zg.gw.entity.Location;
import com.zg.gw.entity.Node;
import com.zg.gw.entity.impl.HumanPlayer;
import com.zg.gw.gui.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengguo on 2018/5/24.
 */
public class GridGame {


    public static int gridGame(List<Location> location, int[] lastmove, List<Node> p) {
        int [] max = {3, 3};

        for (int i=0; i<2; i++) {
            int[] locs = new int[5];
            locs[0] = location.get(i).getX();
            locs[1] = location.get(i).getY();
            locs[2] = location.get(1-i).getX();
            locs[3] = location.get(1-i).getY();
            locs[4] = lastmove[i];

            int  move = p.get(i).evaluate(locs) % 4;
            if (move == -1) return -1;
            if (lastmove[i] == move) return 1-i;
            lastmove[i] = move;
            if (move == 0) {
                location.get(i).setX(location.get(i).getX()-1);
                if (location.get(i).getX() < 0) {
                    location.get(i).setX(max[0]);
                }
            }
            if (move == 1) {
                location.get(i).setX(location.get(i).getX()+1);
                if (location.get(i).getX() > max[0]) {
                    location.get(i).setX(0);
                }
            }
            if (move == 2) {
                location.get(i).setY(location.get(i).getY()-1);
                if (location.get(i).getY() < 0) {
                    location.get(i).setY(max[1]);
                }
            }
            if (move == 3) {
                location.get(i).setY(location.get(i).getY()+1);
                if (location.get(i).getY() > max[1]) {
                    location.get(i).setY(0);
                }
            }

            if (location.get(i).getX() == location.get(1-i).getX() && location.get(i).getY() == location.get(1-i).getY()) {
                return i;
            }
            if (p.get(i) instanceof HumanPlayer) {
                Location me = location.get(i);
                Location others = location.get(1-i);

                for (int k=0; k<4; k++) {
                    for (int j=0; j<4; j++) {
                        if (me.getX() == k && me.getY() == j) {
                            Config.map[k][j] = 2;
                            System.out.print("O");
                        } else if (others.getX() == k && others.getY() == j) {
                            Config.map[k][j] = 1;
                            System.out.print("X");
                        } else {
                            Config.map[k][j] = 0;
                            System.out.print(".");
                        }
                    }
                    System.out.println();
                }
            }

        }

        return -1;
    }
}
