package simple.alert.push.handler;

import org.simple.alert.metadata.MetaDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simple.alert.config.AlertConfigHandler;
import simple.alert.push.PushService;

import java.util.Map;

/**
 * @author luke
 * @date 2021/12/26 18:18
 * @desc 推送配置
 **/
@Component
public class AlertPushHandler {
    @Autowired
    private AlertConfigHandler alertConfigHandler;
    @Autowired
    private Map<String, PushService> pushServiceMap;

    public void push(MetaDataDTO metaDataDTO) {
        pushServiceMap.get(alertConfigHandler.getMode()).push(metaDataDTO);
    }
}
