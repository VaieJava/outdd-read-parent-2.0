package com.outdd.oauthresource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * TODO: [NAME]
 * @author VAIE
 * @date: 2019/3/8-21:20
 * @version v1.0
 */
@RestController
public class TestController {

    @GetMapping("/order/query/{id}")
    public String test(@PathVariable String id){
        return "order id : "+id;
    }

    @GetMapping("/pub/query/{id}")
    public String query(@PathVariable String id){
        return "pub id : "+id;
    }
}
