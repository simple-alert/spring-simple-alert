package org.simple.alert.remote.spring.boot.web.service.component.mysql;


import com.baomidou.mybatisplus.extension.service.IService;
import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.remote.spring.boot.web.model.AlertLog;

public interface AlertLogService extends IService<AlertLog> {
    /**
     * @param metaDataDTO
     * @return {@link null}
     * @author luke
     * @date 16:08 2021/12/26
     * @desc 记录日志
     */
    void insertAlertLog(MetaDataDTO metaDataDTO);
}
