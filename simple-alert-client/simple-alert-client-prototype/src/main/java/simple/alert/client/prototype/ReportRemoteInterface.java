package simple.alert.client.prototype;

import org.simple.alert.core.servlet.ResponseData;
import org.simple.alert.metadata.AlertMetaData;

/**
 * @author luke
 * @date 2021/12/25 16:59
 * @desc 上报数据
 **/
public interface ReportRemoteInterface<T extends AlertMetaData> {
    /**
     * @param httpUrl
     * @param alertMetaData
     * @return {@link ResponseData}
     * @author luke
     * @date 17:00 2021/12/25
     * @desc 上报数据
     */
    ResponseData remoteReport(String httpUrl,T alertMetaData);
}
