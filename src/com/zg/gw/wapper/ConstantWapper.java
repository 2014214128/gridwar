package com.zg.gw.wapper;

import com.zg.gw.function.impl.*;

/**
 * Created by zhengguo on 2018/5/23.
 */
public class ConstantWapper {
    public static FunctionWapper ifw = new FunctionWapper(new IfFunc(), 3, "if");
    public static FunctionWapper gtw = new FunctionWapper(new IsGreaterFunc(), 2, "isgreater");
    public static FunctionWapper addw = new FunctionWapper(new AddFunc(), 2, "add");
    public static FunctionWapper subw = new FunctionWapper(new SubFunc(), 2, "substract");
    public static FunctionWapper mulw = new FunctionWapper(new MulFunc(), 2, "multiply");
    public static FunctionWapper[] flist = {addw, mulw, ifw, gtw, subw};
}
