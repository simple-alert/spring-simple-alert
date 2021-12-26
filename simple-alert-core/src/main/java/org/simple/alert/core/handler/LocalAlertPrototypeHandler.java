package org.simple.alert.core.handler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.simple.alert.core.servlet.BodyReaderRequestWrapper;
import org.simple.alert.core.utils.AlertThreadPoolExecutor;
import org.simple.alert.metadata.expand.LocalStackAlertMetaData;
import org.simple.alert.metadata.expand.LocalWebAlertMetaData;

import javax.servlet.http.HttpServletResponse;

/**
 * @author luke
 * @date 2021/12/25 14:17
 * @desc 收集器
 **/
public class LocalAlertPrototypeHandler {
    /**
     * @return {@link null}
     * @author luke
     * @date 15:59 2021/12/25
     * @desc 同步收集
     */
    public static void reportStackAlert(String eventName, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            LocalStackAlertMetaData localStackAlertMetaData = new LocalStackAlertMetaData();
            localStackAlertMetaData.setThrowable(throwable);
            localStackAlertMetaData.setAlertEventName(eventName);
            localStackAlertMetaData.setLogData(ExceptionUtils.getStackTrace(throwable));
            alertCallBack.call(localStackAlertMetaData);
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
    public static void asyncReportStackAlert(String eventName, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            LocalStackAlertMetaData localStackAlertMetaData = new LocalStackAlertMetaData();
            localStackAlertMetaData.setThrowable(throwable);
            localStackAlertMetaData.setAlertEventName(eventName);
            localStackAlertMetaData.setLogData(ExceptionUtils.getStackTrace(throwable));
            AlertThreadPoolExecutor.getExecutorService().execute(() -> {
                alertCallBack.call(localStackAlertMetaData);
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
    public static void reportWebAlert(String eventName, BodyReaderRequestWrapper request,  Throwable throwable, AlertCallBack alertCallBack) {
        try {
            LocalWebAlertMetaData localWebAlertMetaData = getLocalWebAlertMetaData(eventName, request,  throwable);
            alertCallBack.call(localWebAlertMetaData);
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
    public static void asyncReportWebAlert(String eventName, BodyReaderRequestWrapper request, HttpServletResponse response, Throwable throwable, AlertCallBack alertCallBack) {
        try {
            LocalWebAlertMetaData localWebAlertMetaData = getLocalWebAlertMetaData(eventName, request, throwable);
            AlertThreadPoolExecutor.getExecutorService().execute(() -> {
                alertCallBack.call(localWebAlertMetaData);
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
    private static LocalWebAlertMetaData getLocalWebAlertMetaData(String eventName, BodyReaderRequestWrapper request, Throwable throwable) {
        LocalWebAlertMetaData localWebAlertMetaData = new LocalWebAlertMetaData();
        localWebAlertMetaData.setAlertEventName(eventName);
        localWebAlertMetaData.setUrl(request.getRequestURI());
        localWebAlertMetaData.setBody(request.getBody());
        localWebAlertMetaData.setCookies(JSON.toJSONString(request.getCookies()));
        localWebAlertMetaData.setRequestParams(request.getAllRequestParam());
        localWebAlertMetaData.setRequestHeader(request.getAllHeader());
        localWebAlertMetaData.setLogData(ExceptionUtils.getStackTrace(throwable));
        return localWebAlertMetaData;
    }
}
