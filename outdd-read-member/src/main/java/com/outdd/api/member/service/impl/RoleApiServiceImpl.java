package com.outdd.api.member.service.impl;

import com.outdd.api.member.entity.Role;
import com.outdd.api.member.service.RoleApiService;
import com.outdd.base.BaseApiService;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import com.outdd.dao.RoleRepository;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.outdd.constants.Constants.HTTP_RES_CODE_200;

/*
 * TODO: 菜单实现
 * @author VAIE
 * @date: 2019/4/30-16:17
 * @version v1.0
 */
@RestController
public class RoleApiServiceImpl extends BaseApiService implements RoleApiService {
    @Resource
    RoleRepository roleRepository;


    @Override
    public ResponseBase findRoles(PageHelp page, Role entity) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("roleName", ExampleMatcher.GenericPropertyMatchers.startsWith());//模糊查询匹配开头，即{username}%
//                .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
//                .withIgnorePaths("password")//忽略字段，即不管password是什么值都不加入查询条件
//                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉


        Example<Role> example = Example.of(entity,matcher);
        Pageable pageable = PageRequest.of(page.current - 1, page.size, page.getOrderType(), page.sort);
        Page<Role> pageInfo = roleRepository.findAll(example,pageable );
        return setResult(HTTP_RES_CODE_200,"Page<Role>", pageInfo);
    }

}
