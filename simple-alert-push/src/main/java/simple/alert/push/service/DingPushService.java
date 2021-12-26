package simple.alert.push.service;

import org.simple.alert.metadata.MetaDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simple.alert.push.component.DingDingComponent;
import simple.alert.push.PushService;

/**
 * @author luke
 * @date 2021/12/26 17:58
 * @desc 钉钉推送
 **/
@Component(value = "DingTalk")
public class DingPushService implements PushService {
    @Autowired
    private DingDingComponent dingDingComponent;

    @Override
    public void push(MetaDataDTO metaDataDTO) {
        dingDingComponent.sendMsg(metaDataDTO.getMetaDataEnum().getDesc(), metaDataDTO.getBody());
    }
}
