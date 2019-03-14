package com.outdd.outddreadconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OutddReadConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutddReadConfigServerApplication.class, args);
    }

}
