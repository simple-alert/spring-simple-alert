package org.simple.alert.remote.spring.boot.web.constant;

/**
 * @author luke
 * @date 2021/12/25 21:38
 * @desc 推送模式
 **/
public enum CollectEnum {

    MYSQL("mysql", "mysql存储");

    private String mode;
    private String desc;

    CollectEnum(String mode, String desc) {
        this.mode = mode;
        this.desc = desc;
    }

    public String getMode() {
        return mode;
    }

    public String getDesc() {
        return desc;
    }
}
