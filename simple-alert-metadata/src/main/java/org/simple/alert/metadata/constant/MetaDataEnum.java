package org.simple.alert.metadata.constant;

import org.simple.alert.metadata.expand.LocalStackAlertMetaData;
import org.simple.alert.metadata.expand.LocalWebAlertMetaData;
import org.simple.alert.metadata.expand.RemoteStackAlertMetaData;
import org.simple.alert.metadata.expand.RemoteWebAlertMetaData;

/**
 * @author luke
 * @date 2021/12/25 21:38
 * @desc 元数据类型
 **/
public enum MetaDataEnum {

    LOCAL_STACK("local_stack", "本地异常", LocalStackAlertMetaData.class),
    LOCAL_WEB_STACK("local_web_stack", "本地web异常", LocalWebAlertMetaData.class),
    REMOTE_STACK("remote_stack", "远程本地异常常", RemoteStackAlertMetaData.class),
    REMOTE_WEB_STACK("remote_web_stack", "远程web异常", RemoteWebAlertMetaData.class);

    private String mode;
    private String desc;
    private Class aClass;

    MetaDataEnum(String mode, String desc, Class aClass) {
        this.mode = mode;
        this.desc = desc;
        this.aClass = aClass;
    }

    public String getMode() {
        return mode;
    }

    public String getDesc() {
        return desc;
    }

    public Class getAClass() {
        return aClass;
    }

    public static Class getClass(MetaDataEnum metaDataEnum) {
        for (MetaDataEnum dataEnum : MetaDataEnum.values()) {
            if (dataEnum.getMode().equals(metaDataEnum.getMode())) {
                return metaDataEnum.aClass;
            }
        }
        return null;
    }
}
