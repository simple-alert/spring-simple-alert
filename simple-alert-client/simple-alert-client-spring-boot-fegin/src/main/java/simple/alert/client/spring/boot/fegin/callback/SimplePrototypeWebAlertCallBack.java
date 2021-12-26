package simple.alert.client.spring.boot.fegin.callback;

import com.alibaba.fastjson.JSON;
import org.simple.alert.core.handler.AlertCallBack;
import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.metadata.expand.RemoteWebAlertMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simple.alert.client.spring.boot.fegin.properties.AlertProperties;
import simple.alert.client.spring.boot.fegin.service.AlertRemoteService;

import javax.annotation.Resource;

import static org.simple.alert.metadata.constant.MetaDataEnum.REMOTE_WEB_STACK;

/**
 * @author luke
 * @date 2021/12/25 15:11
 * @desc 日志回调处理器
 **/
@Component
public class SimplePrototypeWebAlertCallBack implements AlertCallBack<RemoteWebAlertMetaData> {

    @Autowired
    private AlertRemoteService alertRemoteService;
    @Resource
    private AlertProperties alertProperties;

    @Override
    public void call(RemoteWebAlertMetaData remoteWebAlertMetaData) {
        if (alertProperties.getReport()) {
            alertRemoteService.receiveStack(new MetaDataDTO(REMOTE_WEB_STACK, JSON.toJSONString(remoteWebAlertMetaData)));
        }
    }
}
