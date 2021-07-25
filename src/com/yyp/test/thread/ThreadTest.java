package com.yyp.test.thread;

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-25 下午 5:14
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        // ThreadPoolExecutor.CallerRunsPolicy 超出的线程会在调用者线程中同步执行
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2L,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        // ThreadPoolExecutor.AbortPolicy 默认策略，新任务提交时直接抛出未检查的异常RejectedExecutionException，该异常可由调用者捕获。
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2L,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());

        // ThreadPoolExecutor.DiscardPolicy 新提交的任务被抛弃但不抛出异常
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2L,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

        // ThreadPoolExecutor.DiscardOldestPolicy 丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());

        for(int i = 0; i < 20; i++) {
            try {
                threadPoolExecutor.execute(new ThreadTask());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
