package simple.alert.client.spring.boot.fegin.constants;

/**
 * @author luke
 * @date 2021/12/25 21:38
 * @desc 元数据类型
 **/
public enum FeginModeEnum {

    ORIGINAL("original", "原生"),
    DISCOVERY("discovery", "服务发现");

    private String mode;
    private String desc;

    FeginModeEnum(String mode, String desc) {
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
