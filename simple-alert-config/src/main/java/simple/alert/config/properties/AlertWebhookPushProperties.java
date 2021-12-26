package simple.alert.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luke
 * @date 2021/12/25 21:26
 * @desc 告警配置
 **/
@Component
@ConfigurationProperties(prefix = "simple.alert.config.push.webhook")
public class AlertWebhookPushProperties {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
