package simple.alert.client.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luke
 * @date 2021/12/25 21:26
 * @desc 告警配置
 **/
@Component
@ConfigurationProperties(prefix = "simple.alert.prototype")
public class AlertProperties {

    /**
     * 远程地址
     */
    private String httpUrl;
    /**
     * 是否收集
     */
    private Boolean report;

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public Boolean getReport() {
        return report;
    }

    public void setReport(Boolean report) {
        this.report = report;
    }
}
