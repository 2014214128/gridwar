package com.zg.gw.entity.impl;

import com.zg.gw.entity.Location;
import com.zg.gw.entity.Node;
import com.zg.gw.gui.Config;

import java.util.Scanner;

/**
 * Created by zhengguo on 2018/5/24.
 */
public class HumanPlayer implements Node{
    private int move = -1;


    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    @Override
    public int evaluate(int[] inp) {
//        System.out.println(this.move);
        return this.move;
    }

    @Override
    public void display(int indent) {

    }

    @Override
    public Object clone() {
        return null;
    }
}
