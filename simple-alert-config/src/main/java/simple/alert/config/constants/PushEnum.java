package simple.alert.config.constants;

/**
 * @author luke
 * @date 2021/12/25 21:38
 * @desc 推送模式
 **/
public enum PushEnum {

    DingTalk("DingTalk", "钉钉推送");

    private String mode;
    private String desc;

    PushEnum(String mode, String desc) {
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
