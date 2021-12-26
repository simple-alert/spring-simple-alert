package simple.aler.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author luke
 * @date 2021/12/26 12:34
 * @desc 注册中心
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaService {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService.class, args);
    }
}
