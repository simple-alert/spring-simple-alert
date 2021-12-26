package org.simple.alert.remote.spring.boot.web.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanglin
 * @version 1.0
 * @description: mybatis plus 配置
 * @date 2021/7/6 15:31
 */
@Configuration
@MapperScan(basePackages = "org.simple.alert.remote.spring.boot.web.mapper")
public class MybatisPlusConfig {

    /**
     * @description: 分页插件配置
     * @param:
     * @return: com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     * @author wanglin
     * @date: 2021/7/6 15:32
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
