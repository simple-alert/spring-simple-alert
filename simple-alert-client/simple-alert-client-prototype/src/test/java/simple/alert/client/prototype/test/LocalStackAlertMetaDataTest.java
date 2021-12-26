package simple.alert.client.prototype.test;


import org.junit.Test;
import org.simple.alert.core.handler.LocalAlertPrototypeHandler;
import simple.alert.client.prototype.callback.SimplePrototypeLocalAlertCallBack;

/**
 * @author luke
 * @date 2021/12/25 15:07
 * @desc 测试类
 **/

public class LocalStackAlertMetaDataTest {
    @Test
    public void test() {
        LocalAlertPrototypeHandler.reportStackAlert("测试", new RuntimeException(), new SimplePrototypeLocalAlertCallBack());
    }
    @Test
    public void asyncTest() throws InterruptedException {
        LocalAlertPrototypeHandler.asyncReportStackAlert("测试", new RuntimeException(), new SimplePrototypeLocalAlertCallBack());
    }
}
