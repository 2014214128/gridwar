package com.zg.gw.ga;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.impl.FuncNode;
import com.zg.gw.tree.RandomTree;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class Mutate {
    public static Node mutate(Node t, int pc) {
        return mutate(t, pc, 0.1);
    }


    public static Node mutate(Node t, int pc, double probchange) {
        FuncNode result = null;
        if (Math.random() < probchange) {
            return RandomTree.makeRandomTree(pc);
        } else {
            if (!(t instanceof FuncNode)) {
                return t;
            }
            result = (FuncNode) t.clone();
            FuncNode temp = (FuncNode) t;
            for (int i=0; i<temp.getChildren().size(); i++) {
                result.getChildren().set(i, mutate(temp.getChildren().get(i), pc, probchange));
            }
        }
        return result;
    }
}
