package org.simple.alert.remote.spring.boot.web.handler;

import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.remote.spring.boot.web.service.AlertCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author luke
 * @date 2021/12/26 18:05
 * @desc 处理器
 **/
@Component
public class AlertExecuteHandler {
    @Value(value = "${spring.profiles.active}")
    private String mode;
    @Autowired
    private Map<String, AlertCollectService> alertCollectServiceMap;

    public void collectAlertLog(MetaDataDTO metaDataDTO) {
        alertCollectServiceMap.get(mode).save(metaDataDTO);
    }
}
