package simple.alert.client.spring.boot;

import org.simple.alert.core.servlet.HttpServletRequestWrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import simple.alert.client.spring.boot.callback.SimplePrototypeStackAlertCallBack;
import simple.alert.client.spring.boot.callback.SimplePrototypeWebAlertCallBack;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * @author luke
 * @date 2021/12/25 17:48
 * @desc 告警配置
 **/
@Configuration
public class AlertConfig {
    @Resource
    private AlertProperties alertProperties;

    @Bean
    public SimplePrototypeStackAlertCallBack getSimplePrototypeStackAlertCallBack() {
        return new SimplePrototypeStackAlertCallBack(alertProperties.getHttpUrl(), alertProperties.getReport());
    }

    @Bean
    public SimplePrototypeWebAlertCallBack getSimplePrototypeWebAlertCallBack() {
        return new SimplePrototypeWebAlertCallBack(alertProperties.getHttpUrl(), alertProperties.getReport());
    }

    @Bean
    public AlertSpringBootHandler getAlertSpringBootHandler() {
        return new AlertSpringBootHandler();
    }

    // 注册Filter
    @Bean
    public FilterRegistrationBean getHttpServletRequestWrapperFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new HttpServletRequestWrapperFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
