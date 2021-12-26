package org.simple.alert.remote.spring.boot.web.controller;

import com.alibaba.fastjson.JSON;
import org.simple.alert.core.servlet.BodyReaderRequestWrapper;
import org.simple.alert.core.servlet.ResponseData;
import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.remote.spring.boot.web.handler.AlertExecuteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import simple.alert.push.handler.AlertPushHandler;

/**
 * @author luke
 * @date 2021/12/25 20:17
 * @desc 收集器
 **/
@RestController
public class AlertController {

    @Autowired
    private AlertExecuteHandler alertExecuteHandler;
    @Autowired
    private AlertPushHandler alertPushHandler;

    /**
     * @param bodyReaderRequestWrapper
     * @return {@link ResponseData}
     * @author luke
     * @date 18:53 2021/12/25
     * @desc 收集堆栈信息
     */
    @PostMapping(value = "/simple/alert/receive/stack")
    public ResponseData receiveStack(BodyReaderRequestWrapper bodyReaderRequestWrapper) {
        MetaDataDTO metaDataDTO = JSON.parseObject(bodyReaderRequestWrapper.getBody(), MetaDataDTO.class);
        // 入库
        alertExecuteHandler.collectAlertLog(metaDataDTO);
        // 推送
        alertPushHandler.push(metaDataDTO);
        return ResponseData.ok();
    }
}
