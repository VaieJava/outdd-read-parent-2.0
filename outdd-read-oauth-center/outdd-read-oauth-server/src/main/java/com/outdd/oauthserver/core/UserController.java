package com.outdd.oauthserver.core;

import com.outdd.api.member.entity.User;
import com.outdd.base.BaseResponse;
import com.outdd.base.RedisUtil;
import com.outdd.base.ResponseBase;
import com.outdd.oauthserver.feign.MemberApiServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * 通过token获取用户信息
 */
@RestController
public class UserController {
    @Autowired
    RedisUtil redisUtil;
    @Resource
    private MemberApiServiceFeign memberApiServiceFeign;
    @GetMapping("/user")
    public BaseResponse user(Principal user) {

        User qwe=memberApiServiceFeign.loadUserByUsername("admin");
        if(qwe == null) {
        }

        redisUtil.set("123", "124214124124");
        if(user!=null){
            return BaseResponse.success("UserInfo",user);
        }
        return BaseResponse.error("用户不存在！");
    }

    @GetMapping("/user2")
    public BaseResponse user2( Authentication authentication) {
        if(authentication!=null){
            return BaseResponse.success("UserInfo",authentication);
        }
        return BaseResponse.error("用户不存在！");
    }

    @RequestMapping("/findUser/{username}/{password}")
    public ResponseBase findUser(@PathVariable String username, @PathVariable String password){
        return memberApiServiceFeign.findByUsernameAndPassword(username,password);

    }
}