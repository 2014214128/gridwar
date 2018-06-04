package com.zg.gw.ga;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.impl.FuncNode;
import com.zg.gw.function.Func;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class Crossover {

    public static Node crossover(Node t1, Node t2) {
        return crossover(t1, t2, 0.7);
    }

    public static Node crossover(Node t1, Node t2, double probswap) {
        return crossover(t1, t2, probswap, true);
    }

    public static Node crossover(Node t1, Node t2, double probswap, boolean top) {
        FuncNode result = null;
        if (Math.random() < probswap && !top) {
            return (Node) t2.clone();
        } else {
            if (!(t1 instanceof FuncNode && t2 instanceof FuncNode)) {
                return t1;
            }
            result = (FuncNode) t1.clone();
            FuncNode temp = (FuncNode) t1;
            FuncNode temp2 = (FuncNode) t2;
            for (int i=0; i<temp.getChildren().size(); i++) {
                result.getChildren().set(i, crossover(temp.getChildren().get(i), temp2.getChildren().get((int)(Math.random()*temp2.getChildren().size())),probswap, false));
            }
        }
        return result;
    }
}
