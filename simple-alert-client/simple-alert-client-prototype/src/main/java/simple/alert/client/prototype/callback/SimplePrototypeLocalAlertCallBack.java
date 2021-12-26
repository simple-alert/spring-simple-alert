package simple.alert.client.prototype.callback;

import com.alibaba.fastjson.JSON;
import org.simple.alert.core.handler.AlertCallBack;
import org.simple.alert.metadata.expand.LocalStackAlertMetaData;

/**
 * @author luke
 * @date 2021/12/25 15:11
 * @desc 日志回调处理器
 **/
public class SimplePrototypeLocalAlertCallBack implements AlertCallBack<LocalStackAlertMetaData> {
    @Override
    public void call(LocalStackAlertMetaData localStackAlertMetaData) {
        System.out.println(JSON.toJSONString(localStackAlertMetaData));
    }
}
