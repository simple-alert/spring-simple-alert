package org.simple.alert.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import simple.alert.client.spring.boot.fegin.annotation.EnableAlert;
import simple.alert.client.spring.boot.fegin.service.AlertRemoteService;

/**
 * @author luke
 * @date 19:39 2021/12/25
 * @desc 服务启动
 */
@EnableFeignClients(basePackageClasses = AlertRemoteService.class)
@EnableDiscoveryClient
@SpringBootApplication
@EnableAlert
public class SimpleAlertExample {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpringApplication.run(SimpleAlertExample.class, args);
        System.out.println("SimpleAlertExample服务启动成功,耗时" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
