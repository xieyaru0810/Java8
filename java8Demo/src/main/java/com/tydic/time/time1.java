package com.tydic.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class time1 {


    public static void main(String[] args) {
        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //定义格式化的对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> callable = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                //调用LocalDate.parse方法并传入格式化对象即可
                //传统解决线程安全问题的方法：
                //传统的时间格式化是：DateFormatThreadLocal.convert("20181226");
                //输出结果：Sun Dec 18 00:00:00 CST 2018
                return LocalDate.parse("20181226",dtf);
            };
        };

        //记得关闭池
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> LocalDates = new ArrayList();

        for(int i=0;i<10000;i++){
            LocalDates.add(pool.submit(callable));
        }

        LocalDates.forEach((Future<LocalDate> LocalDateFuture) -> {
            try {
                System.out.println(LocalDateFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

    //线程不安全的
    /*输出：
    Fri Oct 12 00:00:00 CST 2018
java.util.concurrent.ExecutionException: java.lang.NumberFormatException: For input string: ""
	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
	at java.util.concurrent.FutureTask.get(FutureTask.java:192)
     */
    @Test
    public void test1(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //由于线程非安全，所以往pool中同时放入100个任务并开启10000个线程去执行如下
//                的代码就会报错。100不报错，就改成1000,1000不报错就改成10000.你的机子
//                越牛逼。这个数字就越大。但是肯定会报错
                return sdf.parse("20181226");
            };
        };

        List<Future<Date>> dates = new ArrayList();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            dates.add(pool.submit(callable));
        }

        dates.forEach((Future<Date> dateFuture) -> {
            try {
                System.out.println(dateFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
