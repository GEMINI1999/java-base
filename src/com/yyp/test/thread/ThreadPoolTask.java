package com.yyp.test.thread;

import java.io.Serializable;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-25 下午 10:29
 * @Version 1.0
 */
public class ThreadPoolTask implements Runnable, Serializable {
    private static final long serialVersionUID = 0;
    private static int consumeTaskSleepTime = 2000;
    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("start .." + threadPoolTaskData);

        try {
            // //便于观察，等待一段时间
            Thread.sleep(consumeTaskSleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolTaskData = null;
    }

    public Object getTask() {
        return this.threadPoolTaskData;
    }
}
