package com.outdd.api.member.service.impl;

import com.outdd.api.member.entity.User;
import com.outdd.api.member.service.MemberApiService;
import com.outdd.base.BaseApiService;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import com.outdd.dao.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.outdd.constants.Constants.HTTP_RES_CODE_200;

/**
 * @author vaie
 * @Created 2019/1/26 17:46
 */
@RestController
public class MemberApiServiceImpl extends BaseApiService implements MemberApiService {
    @Resource
    UserRepository userRepository;
    @Override
    public ResponseBase findById(@PathVariable String id) {
        ResponseBase responseBase = setResultError("非法错误");
        if(id != null){
            try {
                int idNum=(int)Integer.valueOf(id);
                User user=userRepository.findById(idNum);
                if(user!=null){
                    responseBase = setResult(HTTP_RES_CODE_200,"",user);
                }
            }catch (Exception e){
                responseBase = setResultError("id不能为非数字");
            }
        }else{
            responseBase = setResultError("id不能为null");
        }



        return responseBase;
    }

    @Override
    public ResponseBase findByUsernameAndPassword(@PathVariable String username,@PathVariable String password) {
//        password=PasswordUtil.getEncryptionPassword(password);
        User user=userRepository.findByUsernameAndPassword(username,password);
        ResponseBase responseBase = setResultError("用户名或密码不对");
        if(user!=null){
            responseBase = setResult(HTTP_RES_CODE_200,"",user);
        }
        return responseBase;
    }

    @Override
    public User loadUserByUsername(@PathVariable String username) {
        User user = userRepository.findByName(username);
        return user;
    }

    @Override
    public ResponseBase findUsers(PageHelp page, User entity) {
        Sort.Direction sort =  Sort.Direction.ASC;
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith());//模糊查询匹配开头，即{username}%
//                .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
//                .withIgnorePaths("password")//忽略字段，即不管password是什么值都不加入查询条件
//                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉


        Example<User> example = Example.of(entity,matcher);
        Pageable pageable = PageRequest.of(page.current - 1, page.size, page.getOrderType(), page.sort);
        Page<User> pageInfo = userRepository.findAll(example,pageable );
        return setResult(HTTP_RES_CODE_200,"Page<User>", pageInfo);
    }
}
