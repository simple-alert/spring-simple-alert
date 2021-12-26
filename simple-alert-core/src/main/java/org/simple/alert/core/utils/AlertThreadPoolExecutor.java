package org.simple.alert.core.utils;

import java.util.concurrent.*;

/**
 * @author luke
 * @date 2021/12/25 15:26
 * @desc 告警线程池
 **/
public class AlertThreadPoolExecutor {
    private static ExecutorService executorService;

    private int corePoolSize = 2;
    private int maximumPoolSize = 200;
    private long keepAliveTime = 15;
    private TimeUnit unit = TimeUnit.SECONDS;
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(1000);

    public static void setExecutorService(ExecutorService executorService) {
        AlertThreadPoolExecutor.executorService = executorService;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public BlockingQueue<Runnable> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    public ExecutorService init() {
        executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        return executorService;
    }

    /**
     * @return {@link null}
     * @author luke
     * @date 15:38 2021/12/25
     * @desc 获取线程池
     */
    public static ExecutorService getExecutorService() {
        if (null == executorService) {
            return new AlertThreadPoolExecutor().init();
        }
        return executorService;
    }

}
