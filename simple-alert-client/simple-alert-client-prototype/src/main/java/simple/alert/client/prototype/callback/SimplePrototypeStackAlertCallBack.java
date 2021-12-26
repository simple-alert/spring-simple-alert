package simple.alert.client.prototype.callback;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.simple.alert.core.handler.AlertCallBack;
import org.simple.alert.metadata.expand.LocalStackAlertMetaData;

/**
 * @author luke
 * @date 2021/12/25 15:11
 * @desc 日志回调处理器
 **/
public class SimplePrototypeStackAlertCallBack implements AlertCallBack<LocalStackAlertMetaData> {

    private String httpUrl;
    private boolean isReport = false;

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public boolean isReport() {
        return isReport;
    }

    public void setReport(boolean report) {
        isReport = report;
    }

    public SimplePrototypeStackAlertCallBack(String httpUrl, boolean isReport) {
        this.httpUrl = httpUrl;
        this.isReport = isReport;
    }

    @Override
    public void call(LocalStackAlertMetaData localStackAlertMetaData) {
        if (isReport) {
            HttpUtil.post(httpUrl, JSON.toJSONString(localStackAlertMetaData), 3000);
        }
    }
}
