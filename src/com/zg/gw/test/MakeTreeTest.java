package com.zg.gw.test;

import com.zg.gw.entity.Node;
import com.zg.gw.entity.impl.ConstNode;
import com.zg.gw.entity.impl.FuncNode;
import com.zg.gw.entity.impl.ParamNode;
import com.zg.gw.function.impl.*;
import com.zg.gw.wapper.FunctionWapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class MakeTreeTest {
    private static FunctionWapper ifw = new FunctionWapper(new IfFunc(), 3, "if");
    private static FunctionWapper gtw = new FunctionWapper(new IsGreaterFunc(), 2, "isgreater");
    private static FunctionWapper addw = new FunctionWapper(new AddFunc(), 2, "add");
    private static FunctionWapper subw = new FunctionWapper(new SubFunc(), 2, "substract");
    private static FunctionWapper mulw = new FunctionWapper(new MulFunc(), 2, "multiply");

    private static FunctionWapper[] flist = {new FunctionWapper(new AddFunc(), 2, "add"),
                                        new FunctionWapper(new MulFunc(), 2, "multiply"),
                                        new FunctionWapper(new IfFunc(), 3, "if"),
                                        new FunctionWapper(new IsGreaterFunc(), 2, "isgreater"),
                                        new FunctionWapper(new SubFunc(), 2, "substract")};

    public static FuncNode exampleTree() {
        List<Node> param1 = new ArrayList<>();
        param1.add(new ParamNode(0));
        param1.add(new ConstNode(3));
        List<Node> param2 = new ArrayList<>();
        param1.add(new ParamNode(1));
        param1.add(new ConstNode(5));
        List<Node> param3 = new ArrayList<>();
        param1.add(new ParamNode(1));
        param1.add(new ConstNode(2));

        Node nlist1 = new FuncNode(gtw, param1);
        Node nlist2 = new FuncNode(addw, param2);
        Node nlist3 = new FuncNode(subw, param3);

        List<Node> nlist4 = new ArrayList<>();
        nlist4.add(nlist1);
        nlist4.add(nlist2);
        nlist4.add(nlist3);


        return new FuncNode(ifw, nlist4);
    }

    public static void main(String[] args) {
        Node exampleTree = exampleTree();

        exampleTree.display(0);

        int[] inp = {5, 3};
        System.out.println(exampleTree.evaluate(inp));
    }

}
