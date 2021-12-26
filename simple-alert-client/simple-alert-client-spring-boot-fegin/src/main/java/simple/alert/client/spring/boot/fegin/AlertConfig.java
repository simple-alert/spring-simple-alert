package simple.alert.client.spring.boot.fegin;

import org.simple.alert.core.servlet.HttpServletRequestWrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import simple.alert.client.spring.boot.fegin.callback.SimplePrototypeStackAlertCallBack;
import simple.alert.client.spring.boot.fegin.callback.SimplePrototypeWebAlertCallBack;
import simple.alert.client.spring.boot.fegin.handler.AlertSpringBootHandler;
import simple.alert.client.spring.boot.fegin.handler.FeignClientsServiceNameAppendBeanPostProcessor;

import javax.servlet.Filter;

/**
 * @author luke
 * @date 2021/12/25 18:55
 * @desc 本地配置
 **/
@Configuration
public class AlertConfig {


    @Bean
    public AlertSpringBootHandler getAlertSpringBootHandler() {
        return new AlertSpringBootHandler();
    }


    @Bean
    public SimplePrototypeStackAlertCallBack getSimplePrototypeStackAlertCallBack() {
        return new SimplePrototypeStackAlertCallBack();
    }

    @Bean
    public SimplePrototypeWebAlertCallBack getSimplePrototypeWebAlertCallBack() {
        return new SimplePrototypeWebAlertCallBack();
    }
    @Bean
    public FeignClientsServiceNameAppendBeanPostProcessor getFeignClientsServiceNameAppendBeanPostProcessor(){
        return new FeignClientsServiceNameAppendBeanPostProcessor();
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
