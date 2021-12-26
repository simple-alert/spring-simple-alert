package simple.alert.client.spring.boot.fegin.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import simple.alert.client.spring.boot.fegin.constants.FeginModeEnum;
import simple.alert.client.spring.boot.fegin.properties.AlertProperties;
import simple.alert.client.spring.boot.fegin.service.AlertRemoteService;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static org.simple.alert.core.constant.AlertConstant.SERVICE_NAME;

/**
 * @author luke
 * @date 2021/12/26 0:39
 * @desc fegin 后置处理器
 **/
@Component
public class FeignClientsServiceNameAppendBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    @Value(value = "${spring.application.name}")
    private String serviceName;
    @Resource
    private AlertProperties alertProperties;
    private ApplicationContext applicationContext;

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            if (atomicInteger.getAndIncrement() == 0) {
                String beanNameOfFeignClientFactoryBean = "org.springframework.cloud.openfeign.FeignClientFactoryBean";
                Class beanNameClz = Class.forName(beanNameOfFeignClientFactoryBean);

                applicationContext.getBeansOfType(beanNameClz).forEach((feignBeanName, beanOfFeignClientFactoryBean) -> {
                    try {
                        if (feignBeanName.equals("&" + AlertRemoteService.class.getName())) {
                            if (alertProperties.getMode().equals(FeginModeEnum.ORIGINAL.getMode())) {
                                setField(beanNameClz, "url", beanOfFeignClientFactoryBean, alertProperties.getHttpUrl());
                                setField(beanNameClz, "name", beanOfFeignClientFactoryBean, "");
                                setField(beanNameClz, "contextId", beanOfFeignClientFactoryBean, "");
                            }
                            if (alertProperties.getMode().equals(FeginModeEnum.DISCOVERY.getMode())) {
                                String feginName = StringUtils.isEmpty(alertProperties.getServiceName())?serviceName:alertProperties.getServiceName();
                                setField(beanNameClz, "url", beanOfFeignClientFactoryBean, "http://" + feginName);
                                setField(beanNameClz, "name", beanOfFeignClientFactoryBean, feginName);
                                setField(beanNameClz, "contextId", beanOfFeignClientFactoryBean, feginName);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(feignBeanName + "-->" + beanOfFeignClientFactoryBean);
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void setField(Class clazz, String fieldName, Object obj, String newValue) throws Exception {

        Field field = ReflectionUtils.findField(clazz, fieldName);
        if (Objects.nonNull(field)) {
            ReflectionUtils.makeAccessible(field);
            Object value = field.get(obj);
            if (Objects.nonNull(value)) {
                if(value.toString().equals(SERVICE_NAME)){
                    ReflectionUtils.setField(field, obj, newValue);
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
