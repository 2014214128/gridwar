package com.zg.gw.tree;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.impl.FuncNode;
import com.zg.gw.entity.impl.ParamNode;
import com.zg.gw.function.Func;

/**
 * Created by zhengguo on 2018/5/24.
 */
public class CopyTree {
    public static Node copyTree(Node tree) {
        if (tree instanceof FuncNode) {
            FuncNode node = (FuncNode) tree.clone();
            node.setFunction((Func) ((FuncNode) tree).getFunction().clone());
            for (int i=0; i<((FuncNode) tree).getChildren().size(); i++)
                node.getChildren().set(i, copyTree(((FuncNode) tree).getChildren().get(i))) ;
            return node;
        }else{
            return (Node) tree.clone();
        }
    }
}
