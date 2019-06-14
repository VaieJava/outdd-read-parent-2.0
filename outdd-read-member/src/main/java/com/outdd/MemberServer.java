package com.outdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 会员服务器启动程序
 * @author vaie
 * @Created 2019/1/26 14:57
 */
@SpringBootApplication
public class MemberServer {
    public static void main(String [] args){
        SpringApplication.run(MemberServer.class,args);
    }
}
