package com.outdd.api.service;

import com.outdd.api.entity.User;
import com.outdd.base.ResponseBase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vaie
 * @Created 2019/1/26 17:45
 */
@RequestMapping("/member")
public interface MemberApiService {

    @RequestMapping("/findById/{id}")
    public ResponseBase findById(@PathVariable(value="id") String id);

    @RequestMapping("findUser/{username}/{password}")
    public ResponseBase findByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password);

    @RequestMapping("loadUserByUsername/{username}")
    public User loadUserByUsername(@PathVariable("username") String username);
}
