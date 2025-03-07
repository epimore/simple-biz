package cn.epimore.gmv.service.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger2", name = "enable", matchIfMissing = false)
public class SwaggerConfig {
    @Value("${swagger2.basePackage}")
    private String basePackage;
    @Value("${swagger2.verison}")
    private String verison;
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean
    public Docket getUserDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(title)
                .description(title)
                .version(verison)
                .contact("gmv")
                .build();
        return new Docket(DocumentationType.SWAGGER_2).enable(enable)//文档类型（swagger2）
                .apiInfo(apiInfo)//设置包含在json ResourceListing响应中的api元信息
                .select()//启动用于api选择的构建器
                .apis(RequestHandlerSelectors.basePackage(basePackage))//扫描接口的包
                .paths(PathSelectors.any())//路径过滤器（扫描所有路径）
                .build();
    }
}
