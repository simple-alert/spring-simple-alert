package org.simple.alert.metadata;

/**
 * @author luke
 * @date 2021/12/25 13:46
 * @desc 远程收集元数据
 **/
public class RemoteAlertMetaData extends AlertMetaData {
    /**
     * 事件名
     */
    private String alertEventName;
    /**
     * 线程Id
     */
    private String threadId = String.valueOf(Thread.currentThread().getId());
    /**
     * 线程名
     */
    private String threadName = Thread.currentThread().getName();

    /**
     * 应用IP
     */
    private String host;

    /**
     * 应用端口
     */
    private String port;

    public String getAlertEventName() {
        return alertEventName;
    }

    public void setAlertEventName(String alertEventName) {
        this.alertEventName = alertEventName;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
