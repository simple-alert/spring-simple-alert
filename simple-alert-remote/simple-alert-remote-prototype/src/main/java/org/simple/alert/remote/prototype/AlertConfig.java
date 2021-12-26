package org.simple.alert.remote.prototype;

import org.simple.alert.core.servlet.HttpServletRequestWrapperFilter;
import org.simple.alert.remote.prototype.controller.AlertController;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author luke
 * @date 2021/12/25 17:48
 * @desc 告警配置
 **/
@Configuration
@ComponentScan(basePackageClasses = AlertController.class)
public class AlertConfig {

    // 注册Filter
    @Bean
    public FilterRegistrationBean getHttpServletRequestWrapperFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new HttpServletRequestWrapperFilter());
        filterRegistrationBean.addUrlPatterns("/simple/alert/receive/*");
        return filterRegistrationBean;
    }
}
