package com.outdd.literature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.outdd"})
@EntityScan(basePackages= {"com.outdd.api.literature.entity"})
public class LiteratureApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiteratureApplication.class, args);
    }

}
