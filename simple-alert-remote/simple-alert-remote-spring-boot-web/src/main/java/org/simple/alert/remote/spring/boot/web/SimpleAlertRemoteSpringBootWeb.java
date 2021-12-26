package org.simple.alert.remote.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import simple.alert.client.spring.boot.fegin.service.AlertRemoteService;

/**
 * @author luke
 * @date 2021/12/25 20:13
 * @desc 服务启动
 **/
@EnableFeignClients(basePackageClasses = AlertRemoteService.class)
@EnableDiscoveryClient
@SpringBootApplication
public class SimpleAlertRemoteSpringBootWeb {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpringApplication.run(SimpleAlertRemoteSpringBootWeb.class, args);
        System.out.println("SimpleAlertRemoteSpringBootWeb服务启动成功,耗时" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
