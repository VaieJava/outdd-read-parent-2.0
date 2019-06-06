package com.outdd.controller;

import com.outdd.MemberServer;
import com.outdd.api.entity.Menu;
import com.outdd.api.entity.User;
import com.outdd.api.service.MemberApiService;
import com.outdd.api.service.MenuApiService;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * TODO: [NAME]
 * @author VAIE
 * @date: 2019/4/30-16:43
 * @version v1.0
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberApiService memberApiService;


    @GetMapping("/findUsers")
    public ResponseBase findUsers(PageHelp page, User entity) {

        return memberApiService.findUsers(page,entity);
    }
}
