package simple.alert.config;

import org.springframework.stereotype.Component;
import simple.alert.config.properties.AlertPushModeProperties;

import javax.annotation.Resource;

/**
 * @author luke
 * @date 2021/12/26 17:50
 * @desc 配置处理器
 **/
@Component
public class AlertConfigHandler {
    @Resource
    private AlertPushModeProperties alertPushModeProperties;

    public String getMode() {
        return alertPushModeProperties.getMode();
    }
}
