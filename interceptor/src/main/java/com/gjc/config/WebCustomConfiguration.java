package com.gjc.config;

import com.gjc.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器的注册
 */
public class WebCustomConfiguration implements WebMvcConfigurer {


    // 配置跨域（这个会导致，走完拦截器还会走这边）第一种
    //    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")   //允许跨域的域名，可以用*表示允许任何域名使用
//                //暴露header中的其他属性给客户端应用程序
//                //如果不设置这个属性前端无法通过response header获取到Authorization也就是token
//                .exposedHeaders("Authorization")
//                .allowCredentials(true) //带上cookie信息
//                .allowedMethods("GET", "POST", "DELETE", "PUT")
//                .maxAge(3600);
//
//    }

    // 第二种
    // 因为上面那个方法拦截器会导致跨域失效（让请求先走filter，优先于拦截器执行），单独自定义配置filter进行跨域
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration ();
        // 设置允许跨域请求的域名
        config.addAllowedOrigin("*");
        // 是否允许证书 不再默认开启
//        config.setAllowCredentials(true);
        // 设置允许的方法
        config.addAllowedMethod("*");
        // 允许任何头
        config.addAllowedHeader("*");
        config.addExposedHeader("token");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }


    /**
     * 具体将拦截器注入的方法实现
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/loginIn");
    }

}
