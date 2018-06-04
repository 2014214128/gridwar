package com.zg.gw.tree;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.impl.ConstNode;
import com.zg.gw.entity.impl.FuncNode;
import com.zg.gw.entity.impl.ParamNode;
import com.zg.gw.wapper.ConstantWapper;
import com.zg.gw.wapper.FunctionWapper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhengguo on 2018/5/23.
 */
public class RandomTree {

    public static Node makeRandomTree(int pc) {
        return makeRandomTree(pc,4,0.5, 0.6);
    }

    public static Node makeRandomTree(int pc, int maxdepth) {
        return makeRandomTree(pc,maxdepth,0.5, 0.6);
    }

    public static Node makeRandomTree(int pc, int maxdepth, double fpr) {
        return makeRandomTree(pc,maxdepth,fpr, 0.6);
    }

    public static Node makeRandomTree(int pc, int maxdepth, double fpr, double ppr) {
        if (Math.random() < fpr && maxdepth > 0) {
            FunctionWapper f = ConstantWapper.flist[(int)(Math.random()*5)];
            List<Node> children = new ArrayList<>();
            for (int i=0; i<f.getChildCount(); i++) {
                children.add(makeRandomTree(pc, maxdepth-1, fpr, ppr));
            }
            return new FuncNode(f, children);
        } else if (Math.random() < ppr) {
            return new ParamNode((int)(Math.random()*(pc-1)));
        } else {
            return new ConstNode((int)(Math.random()*10));
        }
    }
}
