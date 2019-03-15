package com.outdd.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages= {"com.outdd.oauthserver.feign","com.outdd.api"})
@SpringBootApplication
@ComponentScan(basePackages= {"com.outdd"})
public class OauthServer {

    public static void main(String[] args) {
        SpringApplication.run(OauthServer.class, args);
    }

}
