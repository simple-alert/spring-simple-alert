package org.simple.alert.remote.prototype.controller;

import com.alibaba.fastjson.JSON;
import org.simple.alert.core.handler.AlertCallBack;
import org.simple.alert.core.servlet.BodyReaderRequestWrapper;
import org.simple.alert.core.servlet.ResponseData;
import org.simple.alert.metadata.expand.RemoteStackAlertMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luke
 * @date 2021/12/25 18:22
 * @desc 告警收集
 **/
@RestController
public class AlertController {

    @Autowired
    private AlertCallBack alertCallBack;

    /**
     * @param bodyReaderRequestWrapper
     * @return {@link ResponseData}
     * @author luke
     * @date 18:40 2021/12/25
     * @desc 收集堆栈信息
     */
    @RequestMapping(value = "/simple/alert/receive/stack")
    public ResponseData receiveStack(BodyReaderRequestWrapper bodyReaderRequestWrapper) {
        String body = bodyReaderRequestWrapper.getBody();
        RemoteStackAlertMetaData remoteStackAlertMetaData = JSON.parseObject(body, RemoteStackAlertMetaData.class);
        alertCallBack.call(remoteStackAlertMetaData);
        return ResponseData.ok();
    }
}
