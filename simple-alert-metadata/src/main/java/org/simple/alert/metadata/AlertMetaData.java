package org.simple.alert.metadata;

import java.io.Serializable;

/**
 * @author luke
 * @date 2021/12/25 13:39
 * @desc 日志元数据
 **/
public class AlertMetaData implements Serializable {
    /**
     * 创建时间
     */
    private Long createDate = System.currentTimeMillis();
    /**
     * 日志信息
     */
    private String logData;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }
}
