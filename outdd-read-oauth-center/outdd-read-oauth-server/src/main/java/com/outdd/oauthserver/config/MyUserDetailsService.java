package com.outdd.oauthserver.config;

import com.outdd.api.entity.User;
import com.outdd.base.BaseResponse;
import com.outdd.base.RedisUtil;
import com.outdd.oauthserver.feign.MemberApiServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @Description:
 * @author: 594781919@qq.com
 * @Date: 2018/4/8 15:26
 * @version: 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MemberApiServiceFeign memberApiServiceFeign;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String passw=passwordEncoder.encode(username);
        // TODO 这个地方可以通过username从数据库获取正确的用户信息，包括密码和权限等。
         User user=memberApiServiceFeign.loadUserByUsername(username);
            if(user == null) {
                throw new UsernameNotFoundException(BaseResponse.error("UserDetailsService.userNotFount").getMsg());
            }
        return user;
    }
}