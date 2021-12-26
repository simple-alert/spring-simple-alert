package org.simple.alert.remote.spring.boot.web.service.component.mysql;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.simple.alert.metadata.MetaDataDTO;
import org.simple.alert.metadata.expand.RemoteStackAlertMetaData;
import org.simple.alert.metadata.expand.RemoteWebAlertMetaData;
import org.simple.alert.remote.spring.boot.web.mapper.AlertLogMapper;
import org.simple.alert.remote.spring.boot.web.model.AlertLog;
import org.springframework.stereotype.Service;

import static org.simple.alert.metadata.constant.MetaDataEnum.REMOTE_STACK;
import static org.simple.alert.metadata.constant.MetaDataEnum.REMOTE_WEB_STACK;

/**
 * @author pmh
 */
@Service
public class AlertLogServiceImpl extends ServiceImpl<AlertLogMapper, AlertLog> implements AlertLogService {


    private Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    @Override
    public void insertAlertLog(MetaDataDTO metaDataDTO) {
        if (metaDataDTO.getMetaDataEnum().getMode().equals(REMOTE_STACK.getMode())) {
            RemoteStackAlertMetaData remoteStackAlertMetaData = JSON.parseObject(metaDataDTO.getBody(), RemoteStackAlertMetaData.class);
            AlertLog alertLog = BeanUtil.copyProperties(remoteStackAlertMetaData, AlertLog.class);
            alertLog.setId(snowflake.nextId());
            save(alertLog);
        }
        if (metaDataDTO.getMetaDataEnum().getMode().equals(REMOTE_WEB_STACK.getMode())) {
            RemoteWebAlertMetaData remoteWebAlertMetaData = JSON.parseObject(metaDataDTO.getBody(), RemoteWebAlertMetaData.class);
            AlertLog alertLog = BeanUtil.copyProperties(remoteWebAlertMetaData, AlertLog.class);
            alertLog.setRequestHeader(JSON.toJSONString(remoteWebAlertMetaData.getRequestHeader()));
            alertLog.setRequestParams(JSON.toJSONString(remoteWebAlertMetaData.getRequestParams()));
            alertLog.setId(snowflake.nextId());
            save(alertLog);
        }
    }
}
