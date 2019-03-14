package com.outdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author vaie
 * @Created 2019/1/26 14:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MemberServer {
    public static void main(String [] args){
        SpringApplication.run(MemberServer.class,args);
    }
}
