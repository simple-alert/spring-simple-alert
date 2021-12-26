package simple.alert.client.spring.boot.fegin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luke
 * @date 2021/12/25 21:26
 * @desc 告警配置
 **/
@Component
@ConfigurationProperties(prefix = "simple.alert.remote")
public class AlertProperties {

    private String mode;


    private String serviceName;

    /**
     * 远程地址
     */
    private String httpUrl;
    /**
     * 是否收集
     */
    private Boolean report;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

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
