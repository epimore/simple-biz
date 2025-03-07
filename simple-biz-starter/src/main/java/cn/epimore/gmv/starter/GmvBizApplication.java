package cn.epimore.gmv.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages="cn.epimore.gmv")
@MapperScan({"cn.epimore.gmv.**.mapper"})
@ConfigurationPropertiesScan({"cn.epimore.gmv"})
public class GmvBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmvBizApplication.class, args);
    }

}
