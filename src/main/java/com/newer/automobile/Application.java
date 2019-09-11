package com.newer.automobile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.newer.automobile.mapper")
@EnableRedisHttpSession
@EnableCaching  //开启缓存
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
