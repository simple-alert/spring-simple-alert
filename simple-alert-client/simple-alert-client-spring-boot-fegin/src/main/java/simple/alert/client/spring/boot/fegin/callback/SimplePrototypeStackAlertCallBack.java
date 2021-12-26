package simple.alert.client.spring.boot.fegin.callback;

import com.alibaba.fastjson.JSON;
import org.simple.alert.core.handler.AlertCallBack;
import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.metadata.expand.RemoteStackAlertMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simple.alert.client.spring.boot.fegin.properties.AlertProperties;
import simple.alert.client.spring.boot.fegin.service.AlertRemoteService;

import javax.annotation.Resource;

import static org.simple.alert.metadata.constant.MetaDataEnum.REMOTE_STACK;

/**
 * @author luke
 * @date 2021/12/25 15:11
 * @desc 日志回调处理器
 **/
@Component
public class SimplePrototypeStackAlertCallBack implements AlertCallBack<RemoteStackAlertMetaData> {

    @Autowired
    private AlertRemoteService alertRemoteService;
    @Resource
    private AlertProperties alertProperties;

    @Override
    public void call(RemoteStackAlertMetaData remoteStackAlertMetaData) {
        if (alertProperties.getReport()) {
            alertRemoteService.receiveStack(new MetaDataDTO(REMOTE_STACK, JSON.toJSONString(remoteStackAlertMetaData)));
        }
    }
}
