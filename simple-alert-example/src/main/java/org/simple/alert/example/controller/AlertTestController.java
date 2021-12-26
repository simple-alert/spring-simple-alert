package org.simple.alert.example.controller;

import org.simple.alert.core.servlet.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simple.alert.client.spring.boot.fegin.handler.AlertSpringBootHandler;

/**
 * @author luke
 * @date 2021/12/25 18:51
 * @desc 远程告警服务
 **/
@RestController
public class AlertTestController {
    /**
     * @return {@link ResponseData}
     * @author luke
     * @date 18:53 2021/12/25
     * @desc 收集堆栈信息
     */
    @RequestMapping(value = "/test")
    public void receiveStack() {
        AlertSpringBootHandler.reportWebStack("测试一下",new RuntimeException());
    }
}
