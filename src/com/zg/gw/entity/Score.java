package com.zg.gw.entity;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class Score {

    private int x;
    private int y;
    private int score;

    public Score() {}

    public Score(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
