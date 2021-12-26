package simple.alert.push.component;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import simple.alert.config.properties.AlertWebhookPushProperties;

import javax.annotation.Resource;

/**
 * @description:钉钉机器人工具类
 * @author: len
 * @time: 2020/3/27 11:10
 */
@Component
public class DingDingComponent {

    @Resource
    private AlertWebhookPushProperties alertWebhookPushProperties;

    private static String url = "https://oapi.dingtalk.com/robot/send?access_token=";

    /**
     * @param title 标题
     * @param msg   消息内容
     * @description: 处理发送的钉钉文本消息
     * @author: len
     * @time: 2020/3/27 11:12
     */
    public void sendMsg(String title, String msg) {
        MsgType msgType = new MsgType();
        msgType.setMsgtype("text");
        Content content = new Content();
        content.setContent(msg);
        msgType.setText(content);
        HttpUtil.post(url + alertWebhookPushProperties.getToken(), JSONObject.toJSONString(msgType));
    }
    class MsgType{
        String msgtype;
        Content text;

        public String getMsgtype() {
            return msgtype;
        }

        public void setMsgtype(String msgtype) {
            this.msgtype = msgtype;
        }

        public Content getText() {
            return text;
        }

        public void setText(Content text) {
            this.text = text;
        }
    }
    class Content{
        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}

