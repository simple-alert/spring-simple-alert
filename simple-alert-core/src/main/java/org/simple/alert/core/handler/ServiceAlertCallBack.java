package org.simple.alert.core.handler;

import org.simple.alert.metadata.MetaDataDTO;

/**
 * @author luke
 * @date 2021/12/25 14:29
 * @desc 日志监听器
 **/
public interface ServiceAlertCallBack {
    /**
     * @param metaDataDTO
     * @return {@link null}
     * @author luke
     * @date 14:34 2021/12/25
     * @desc 回调方法
     */
    void call(MetaDataDTO metaDataDTO);
}
