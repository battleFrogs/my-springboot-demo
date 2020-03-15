package com.gjc.config;

import com.gjc.filter.LogCostFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册自定义的filter实现(配合LogCostFilter使用)与  webCustomConfiguration中无关系
 */

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }
}
