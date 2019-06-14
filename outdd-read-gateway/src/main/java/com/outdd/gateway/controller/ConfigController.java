package com.outdd.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${common}")
    private String common;

    @Value("${spring.profile}")
    private String profile;


    @GetMapping("/common")
    public String common(){
        return this.common;
    }

    @GetMapping("/profile")
    public String profile(){
        return this.profile;
    }

}