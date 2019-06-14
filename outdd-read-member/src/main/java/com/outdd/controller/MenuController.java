package com.outdd.controller;

import com.outdd.api.member.entity.Menu;
import com.outdd.api.member.service.MenuApiService;
import com.outdd.common.PageHelp;
import com.outdd.base.ResponseBase;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuApiService menuApiService;


    @GetMapping("/findMenus")
    public ResponseBase findMenus(PageHelp page, Menu entity) {

        return menuApiService.findMenus(page,entity);
    }
}
