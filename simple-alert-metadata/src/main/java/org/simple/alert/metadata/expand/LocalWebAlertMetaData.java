package org.simple.alert.metadata.expand;

import org.simple.alert.metadata.LocalAlertMetaData;

import java.util.Map;

/**
 * @author luke
 * @date 2021/12/25 13:59
 * @desc 本地http异常收集元数据
 **/
public class LocalWebAlertMetaData extends LocalAlertMetaData {
    /**
     * @desc 请求地址
     */
    private String url;
    /**
     * @desc 请求体
     */
    private String body;
    /**
     * @desc cookies
     */
    private String cookies;
    /**
     * @desc 请求参数
     */
    private Map<String, Object> requestParams;
    /**
     * @desc 请求头
     */
    private Map<String, Object> requestHeader;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Map<String, Object> requestParams) {
        this.requestParams = requestParams;
    }

    public Map<String, Object> getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(Map<String, Object> requestHeader) {
        this.requestHeader = requestHeader;
    }
}
