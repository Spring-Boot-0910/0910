package com.newer.automobile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域的配置类
 */
@Configuration
public class CrossConfig {
    /*定义访问源*/
    private final String[] origins={
        "127.0.0.1",
        "localhost",
        "www.baidu.com",
        "google.com"
    };
    @Bean
    public CorsFilter corsFilter(){
        /*创建跨域的配置对象*/
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        /*配置允许访问的访问源*/
        addAllowedOrigin(corsConfiguration);
        /*不限制访问请求头部信息*/
        corsConfiguration.addAllowedHeader("*");
        /*不限制请求方式:post/get/put/delete 都允许请求*/
        corsConfiguration.addAllowedMethod("*");
        /*配置允许session共享*/
        corsConfiguration.setAllowCredentials(true);
        /*创建基于url的跨域配置对象*/
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }

    private void addAllowedOrigin(CorsConfiguration corsConfiguration) {
        /*遍历访问源添加*/
        for (String origin:origins){
            corsConfiguration.addAllowedOrigin("http://"+origin);
            corsConfiguration.addAllowedOrigin("https://"+origin);
        }
    }
}
