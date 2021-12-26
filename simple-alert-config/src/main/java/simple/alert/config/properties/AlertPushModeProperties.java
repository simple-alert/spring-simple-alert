package simple.alert.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luke
 * @date 2021/12/25 21:26
 * @desc 告警配置
 **/
@Component
@ConfigurationProperties(prefix = "simple.alert.config.push")
public class AlertPushModeProperties {

    private String mode;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
