package com.outdd.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.outdd.oauthcommon","com.outdd.oauthserver"})
public class OauthServer {

    public static void main(String[] args) {
        SpringApplication.run(OauthServer.class, args);
    }

}
