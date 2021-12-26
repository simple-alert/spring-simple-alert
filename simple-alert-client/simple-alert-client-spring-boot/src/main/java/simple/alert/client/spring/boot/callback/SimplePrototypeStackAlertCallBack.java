package simple.alert.client.spring.boot.callback;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.simple.alert.core.handler.AlertCallBack;
import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.metadata.expand.RemoteStackAlertMetaData;

import static org.simple.alert.metadata.constant.MetaDataEnum.REMOTE_STACK;

/**
 * @author luke
 * @date 2021/12/25 15:11
 * @desc 日志回调处理器
 **/
public class SimplePrototypeStackAlertCallBack implements AlertCallBack<RemoteStackAlertMetaData> {

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
    public void call(RemoteStackAlertMetaData remoteStackAlertMetaData) {
        if (isReport) {
            HttpUtil.post(httpUrl, JSON.toJSONString(new MetaDataDTO(REMOTE_STACK, JSON.toJSONString(remoteStackAlertMetaData))), 3000);
        }
    }
}
