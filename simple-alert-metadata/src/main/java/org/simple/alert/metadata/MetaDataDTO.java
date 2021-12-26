package org.simple.alert.metadata;

import org.simple.alert.metadata.constant.MetaDataEnum;

import java.io.Serializable;

/**
 * @author luke
 * @date 2021/12/25 21:44
 * @desc 传输对象
 **/
public class MetaDataDTO implements Serializable {
    /**
     * @desc 元数据类型
     */
    private MetaDataEnum metaDataEnum;
    /**
     * @desc json数据
     */
    private String body;

    public MetaDataDTO() {}

    public MetaDataDTO(MetaDataEnum metaDataEnum, String body) {
        this.metaDataEnum = metaDataEnum;
        this.body = body;
    }

    public MetaDataEnum getMetaDataEnum() {
        return metaDataEnum;
    }

    public void setMetaDataEnum(MetaDataEnum metaDataEnum) {
        this.metaDataEnum = metaDataEnum;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
