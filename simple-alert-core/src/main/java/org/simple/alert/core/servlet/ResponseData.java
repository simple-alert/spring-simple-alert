package org.simple.alert.core.servlet;

import org.simple.alert.core.constant.AlertConstant;

import java.io.Serializable;

/**
 * @author luke
 * @date 2021/12/25 16:48
 * @desc 请求返回信息
 **/
public class ResponseData<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseData ok() {
        return new ResponseData(AlertConstant.success, AlertConstant.success_msg);
    }

    public static ResponseData ok(Object data) {
        return new ResponseData(AlertConstant.success, AlertConstant.success_msg, data);
    }

    public static ResponseData error() {
        return new ResponseData(AlertConstant.error, AlertConstant.error_msg);
    }

    public static ResponseData error(Integer code, String errorMsg) {
        return new ResponseData(code, errorMsg);
    }

    /**
     * @return {@link Boolean}
     * @author luke
     * @date 16:55 2021/12/25
     * @desc 是否成功
     */
    public Boolean isSuccess() {
        return AlertConstant.success.equals(this.code);
    }
}
