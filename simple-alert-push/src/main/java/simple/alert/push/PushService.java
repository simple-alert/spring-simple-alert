package simple.alert.push;

import org.simple.alert.metadata.MetaDataDTO;

/**
 * @author luke
 * @date 2021/12/26 17:55
 * @desc 推送服务
 **/
public interface PushService {
    /**
     * @param metaDataDTO
     * @return {@link null}
     * @author luke
     * @date 17:57 2021/12/26
     * @desc 推送
     */
    void push(MetaDataDTO metaDataDTO);
}
