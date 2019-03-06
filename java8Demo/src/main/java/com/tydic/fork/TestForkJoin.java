package com.tydic.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {

    ForkJoinPool pool = new ForkJoinPool();
    RecursiveTask<Long> task = new ForkJoinCalculate(0,100000000L);
//    pool.invoke(task);
//  这里面为什么不可以使用 invoke方法

}
