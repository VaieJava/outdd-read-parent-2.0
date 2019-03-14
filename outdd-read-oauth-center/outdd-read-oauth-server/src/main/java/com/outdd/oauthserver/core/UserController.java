package com.outdd.oauthserver.core;

import com.outdd.base.BaseResponse;
import com.outdd.base.ResponseBase;
import com.outdd.constants.Constants;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

/**
 * 通过token获取用户信息
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public BaseResponse user(Principal user) {
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
}