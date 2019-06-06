package com.outdd.api.service;

import com.outdd.api.entity.Permission;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * TODO: 权限api
 * @author VAIE
 * @date: 2019/4/30-16:13
 * @version v1.0
 */
@RequestMapping("/permission")
public interface PermissionApiService {
    public ResponseBase findPermissions(PageHelp page, Permission entity);

}
