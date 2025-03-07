package cn.epimore.gmv.service.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GmvFilterConfig {
    private final GmvTokenFilter gmvTokenFilter;

    @Autowired
    public GmvFilterConfig(GmvTokenFilter gmvTokenFilter) {
        this.gmvTokenFilter = gmvTokenFilter;
    }

    @Bean
    public FilterRegistrationBean<GmvTokenFilter> tokenFilter() {
        FilterRegistrationBean<GmvTokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(gmvTokenFilter);
        registrationBean.addUrlPatterns("/*"); // 过滤所有请求
        return registrationBean;
    }
}
