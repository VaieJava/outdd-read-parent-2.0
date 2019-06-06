package com.outdd.controller;

import com.outdd.api.service.MemberApiService;
import com.outdd.api.service.MenuApiService;
import com.outdd.base.RedisUtil;
import com.outdd.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vaie
 * @Created 2019/1/28 15:20
 */
@RestController
public class ClientController {
    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/index")
    public String index() {
        OAuth2AuthenticationProcessingFilter wqe;
        return "this is index";
    }



}
