package org.simple.alert.remote.spring.boot.web.service;

import org.simple.alert.metadata.MetaDataDTO;

/**
 * @author luke
 * @date 2021/12/26 18:10
 * @desc 收集日志
 **/
public interface AlertCollectService {
    /**
     * @param metaDataDTO
     * @return {@link null}
     * @author luke
     * @date 18:12 2021/12/26
     * @desc 保存信息
     */
    void save(MetaDataDTO metaDataDTO);
}
