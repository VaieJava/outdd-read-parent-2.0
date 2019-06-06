package com.outdd.api.service;

import com.outdd.api.entity.Role;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * TODO: 菜单api
 * @author VAIE
 * @date: 2019/4/30-16:13
 * @version v1.0
 */
@RequestMapping("/role")
public interface RoleApiService {
    public ResponseBase findRoles(PageHelp page, Role entity);

}
