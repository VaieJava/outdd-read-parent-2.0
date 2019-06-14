package com.outdd.controller;

import com.outdd.api.member.entity.Role;
import com.outdd.api.member.service.RoleApiService;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * TODO: 角色管理
 * @author VAIE
 * @date: 2019/5/22-14:16
 * @version v1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleApiService roleApiService;
    @GetMapping("/findRoles")
    public ResponseBase findRoles(PageHelp page, Role entity) {
        return roleApiService.findRoles(page,entity);
    }
}
