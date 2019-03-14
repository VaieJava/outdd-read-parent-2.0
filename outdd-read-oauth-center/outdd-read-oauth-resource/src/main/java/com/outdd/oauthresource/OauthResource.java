package com.outdd.oauthresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.outdd.oauthcommon","com.outdd.oauthresource"})
public class OauthResource {

    public static void main(String[] args) {
        SpringApplication.run(OauthResource.class, args);
    }

}
