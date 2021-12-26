package simple.alert.client.spring.boot;

import org.simple.alert.core.handler.RemoteAlertPrototypeHandler;
import org.simple.alert.core.servlet.BodyReaderRequestWrapper;
import org.simple.alert.core.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import simple.alert.client.spring.boot.callback.SimplePrototypeStackAlertCallBack;
import simple.alert.client.spring.boot.callback.SimplePrototypeWebAlertCallBack;

import javax.annotation.PostConstruct;

/**
 * @author luke
 * @date 2021/12/25 19:48
 * @desc 收集器
 **/
public class AlertSpringBootHandler {


    private static SimplePrototypeStackAlertCallBack staticSimplePrototypeStackAlertCallBack;
    private static SimplePrototypeWebAlertCallBack staticSimplePrototypeWebAlertCallBack;
    @Autowired
    private SimplePrototypeStackAlertCallBack simplePrototypeStackAlertCallBack;
    @Autowired
    private SimplePrototypeWebAlertCallBack simplePrototypeWebAlertCallBack;

    @PostConstruct
    public void init() {
        staticSimplePrototypeStackAlertCallBack = simplePrototypeStackAlertCallBack;
        staticSimplePrototypeWebAlertCallBack = simplePrototypeWebAlertCallBack;
    }


    /**
     * @param name
     * @param throwable
     * @return {@link null}
     * @author luke
     * @date 19:54 2021/12/25
     * @desc 同步收集异常
     */
    public static void reportStack(String name, Throwable throwable) {

        RemoteAlertPrototypeHandler.reportStackAlert(name, IpUtils.getLocalIP(), IpUtils.getLocalPort(), throwable, staticSimplePrototypeStackAlertCallBack);
    }

    /**
     * @param name
     * @param throwable
     * @return {@link null}
     * @author luke
     * @date 19:54 2021/12/25
     * @desc 异步收集异常
     */
    public static void reportAsyncStack(String name, Throwable throwable) {
        RemoteAlertPrototypeHandler.reportStackAlert(name, IpUtils.getLocalIP(), IpUtils.getLocalPort(), throwable, staticSimplePrototypeStackAlertCallBack);
    }

    /**
     * @param eventName
     * @param throwable
     * @return {@link null}
     * @author luke
     * @date 19:54 2021/12/25
     * @desc 同步收集web异常
     */
    public static void reportWebStack(String eventName, Throwable throwable) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        BodyReaderRequestWrapper request = (BodyReaderRequestWrapper) requestAttributes.getRequest();
        RemoteAlertPrototypeHandler.reportWebAlert(eventName, IpUtils.getIpAddr(request), IpUtils.getPort(request), request, throwable, staticSimplePrototypeWebAlertCallBack);
    }

    /**
     * @param eventName
     * @param throwable
     * @return {@link null}
     * @author luke
     * @date 19:54 2021/12/25
     * @desc 异步收集web异常
     */
    public static void reportAsyncWebStack(String eventName, Throwable throwable) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        BodyReaderRequestWrapper request = (BodyReaderRequestWrapper) requestAttributes.getRequest();
        RemoteAlertPrototypeHandler.reportWebAlert(eventName, IpUtils.getIpAddr(request), IpUtils.getPort(request), request, throwable, staticSimplePrototypeWebAlertCallBack);
    }
}
