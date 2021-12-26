package org.simple.alert.remote.spring.boot.web.service.component.mysql;

import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.remote.spring.boot.web.service.AlertCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luke
 * @date 2021/12/26 18:12
 * @desc 保存到mysql
 **/
@Component(value = "mysql")
public class MysqlAlertLogService implements AlertCollectService {
    @Autowired
    private AlertLogService alertLogService;

    @Override
    public void save(MetaDataDTO metaDataDTO) {
        alertLogService.insertAlertLog(metaDataDTO);
    }
}
