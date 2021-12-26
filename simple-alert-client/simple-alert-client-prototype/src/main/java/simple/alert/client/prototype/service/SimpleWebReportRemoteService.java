package simple.alert.client.prototype.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.simple.alert.core.servlet.ResponseData;
import org.simple.alert.metadata.expand.LocalWebAlertMetaData;
import simple.alert.client.prototype.ReportRemoteInterface;

/**
 * @author luke
 * @date 2021/12/25 16:42
 * @desc 远程上报配置
 **/
public class SimpleWebReportRemoteService implements ReportRemoteInterface<LocalWebAlertMetaData> {

    @Override
    public ResponseData remoteReport(String httpUrl, LocalWebAlertMetaData alertMetaData) {

        String data = HttpUtil.post(httpUrl, JSON.toJSONString(alertMetaData), 3000);
        ResponseData responseData = JSONObject.parseObject(data, ResponseData.class);
        return responseData;
    }
}
