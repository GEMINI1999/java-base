package com.yyp.test.thread;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-25 下午 9:41
 * @Version 1.0
 */
public class ThreadTask implements Runnable{

    public ThreadTask() {

    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
