package org.simple.alert.metadata;

/**
 * @author luke
 * @date 2021/12/25 13:46
 * @desc 本地收集元数据
 **/
public class LocalAlertMetaData extends AlertMetaData {
    /**
     * 事件名
     */
    private String alertEventName;
    /**
     * 线程Id
     */
    private long threadId = Thread.currentThread().getId();
    /**
     * 线程名
     */
    private String threadName = Thread.currentThread().getName();

    public String getAlertEventName() {
        return alertEventName;
    }

    public void setAlertEventName(String alertEventName) {
        this.alertEventName = alertEventName;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
