package org.simple.alert.core.handler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.simple.alert.core.servlet.BodyReaderRequestWrapper;
import org.simple.alert.core.utils.AlertThreadPoolExecutor;
import org.simple.alert.metadata.expand.RemoteStackAlertMetaData;
import org.simple.alert.metadata.expand.RemoteWebAlertMetaData;

import javax.servlet.http.HttpServletResponse;

/**
 * @author luke
 * @date 2021/12/25 14:17
 * @desc 收集器
 **/
public class RemoteAlertPrototypeHandler {
    /**
     * @return {@link null}
     * @author luke
     * @date 15:59 2021/12/25
     * @desc 同步收集
     */
    public static void reportStackAlert(String eventName, String host, String port, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            RemoteStackAlertMetaData remoteStackAlertMetaData = new RemoteStackAlertMetaData();
            remoteStackAlertMetaData.setAlertEventName(eventName);
            remoteStackAlertMetaData.setThrowable(throwable);
            remoteStackAlertMetaData.setHost(host);
            remoteStackAlertMetaData.setPort(port);
            remoteStackAlertMetaData.setLogData(ExceptionUtils.getStackTrace(throwable));
            alertCallBack.call(remoteStackAlertMetaData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return {@link null}
     * @author luke
     * @date 15:59 2021/12/25
     * @desc 异步收集
     */
    public static void asyncReportStackAlert(String eventName, String host, String port, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            RemoteStackAlertMetaData remoteStackAlertMetaData = new RemoteStackAlertMetaData();
            remoteStackAlertMetaData.setAlertEventName(eventName);
            remoteStackAlertMetaData.setThrowable(throwable);
            remoteStackAlertMetaData.setHost(host);
            remoteStackAlertMetaData.setPort(port);
            remoteStackAlertMetaData.setLogData(ExceptionUtils.getStackTrace(throwable));
            AlertThreadPoolExecutor.getExecutorService().execute(() -> {
                alertCallBack.call(remoteStackAlertMetaData);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return {@link null}
     * @author luke
     * @date 15:59 2021/12/25
     * @desc 同步收集
     */
    public static void reportWebAlert(String eventName, String host, String port, BodyReaderRequestWrapper request, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            RemoteWebAlertMetaData remoteWebAlertMetaData = getLocalWebAlertMetaData(eventName, host, port, request, throwable);
            alertCallBack.call(remoteWebAlertMetaData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return {@link null}
     * @author luke
     * @date 15:59 2021/12/25
     * @desc 异步收集
     */
    public static void asyncReportWebAlert(String eventName, String host, String port, BodyReaderRequestWrapper request, HttpServletResponse response, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            RemoteWebAlertMetaData remoteWebAlertMetaData = getLocalWebAlertMetaData(eventName, host, port, request, throwable);
            AlertThreadPoolExecutor.getExecutorService().execute(() -> {
                alertCallBack.call(remoteWebAlertMetaData);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return {@link null}
     * @author luke
     * @date 16:28 2021/12/25
     * @desc 构建元数据
     */
    private static RemoteWebAlertMetaData getLocalWebAlertMetaData(String eventName, String host, String port, BodyReaderRequestWrapper request, Throwable throwable) {
        RemoteWebAlertMetaData remoteWebAlertMetaData = new RemoteWebAlertMetaData();
        remoteWebAlertMetaData.setUrl(request.getRequestURI());
        remoteWebAlertMetaData.setBody(request.getBody());
        remoteWebAlertMetaData.setCookies(JSON.toJSONString(request.getCookies()));
        remoteWebAlertMetaData.setRequestParams(request.getAllRequestParam());
        remoteWebAlertMetaData.setRequestHeader(request.getAllHeader());
        remoteWebAlertMetaData.setAlertEventName(eventName);
        remoteWebAlertMetaData.setHost(host);
        remoteWebAlertMetaData.setPort(port);
        remoteWebAlertMetaData.setLogData(ExceptionUtils.getStackTrace(throwable));
        return remoteWebAlertMetaData;
    }
}
