package com.outdd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vaie
 * @Created 2019/1/28 15:20
 */
@RestController
public class ClientController {
    @GetMapping("/index")
    public String index() {
        return "this is index";
    }
}
