package org.simple.alert.remote.spring.boot.web.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author luke
 * @date 2021/12/26 15:58
 * @desc 日志模型
 **/
@Data
@TableName(value = "alert_log")
public class AlertLog implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long Id;
    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Long createDate;
    /**
     * 日志信息
     */
    @TableField(value = "log_data")
    private String logData;

    /**
     * 事件名
     */
    @TableField(value = "alert_event_name")
    private String alertEventName;
    /**
     * 线程Id
     */
    @TableField(value = "thread_id")
    private String threadId;
    /**
     * 线程名
     */
    @TableField(value = "thread_name")
    private String threadName;

    /**
     * 应用IP
     */
    @TableField(value = "host")
    private String host;

    /**
     * 应用端口
     */
    @TableField(value = "port")
    private String port;

    /**
     * @desc 请求地址
     */
    @TableField(value = "url")
    private String url;
    /**
     * @desc 请求体
     */
    @TableField(value = "body")
    private String body;
    /**
     * @desc cookies
     */
    @TableField(value = "cookies")
    private String cookies;
    /**
     * @desc 请求参数
     */
    @TableField(value = "requestParams")
    private String requestParams;
    /**
     * @desc 请求头
     */
    @TableField(value = "requestHeader")
    private String requestHeader;
}
