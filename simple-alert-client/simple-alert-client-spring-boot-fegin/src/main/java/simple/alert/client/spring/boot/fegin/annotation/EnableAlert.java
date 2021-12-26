package simple.alert.client.spring.boot.fegin.annotation;

import org.springframework.context.annotation.Import;
import simple.alert.client.spring.boot.fegin.AlertConfig;

import java.lang.annotation.*;

/**
 * @author luke
 * @date 2021/12/26 13:13
 * @desc 实现接口
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AlertConfig.class)
public @interface EnableAlert {
}
