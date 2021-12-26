package simple.alert.client.spring.boot.fegin.service;

import org.simple.alert.core.servlet.ResponseData;
import org.simple.alert.metadata.MetaDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.simple.alert.core.constant.AlertConstant.SERVICE_NAME;

/**
 * @author luke
 * @date 2021/12/25 18:51
 * @desc 远程告警服务
 **/
@FeignClient(name = SERVICE_NAME)
public interface AlertRemoteService {
    /**
     * @param metaDataDTO
     * @return {@link ResponseData}
     * @author luke
     * @date 18:53 2021/12/25
     * @desc 收集堆栈信息
     */
    @RequestMapping(value = "/simple/alert/receive/stack")
    ResponseData receiveStack(MetaDataDTO metaDataDTO);
}
