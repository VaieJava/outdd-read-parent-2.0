package com.outdd.controller;

import com.outdd.api.member.entity.Permission;
import com.outdd.api.member.service.PermissionApiService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionApiService permissionApiService;
    @GetMapping("/findPermissions")
    public ResponseBase findPermissions(PageHelp page, Permission entity) {
        return permissionApiService.findPermissions(page,entity);
    }
}
