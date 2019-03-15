package com.outdd.api.service.impl;

import com.outdd.api.entity.User;
import com.outdd.api.service.MemberApiService;
import com.outdd.base.BaseApiService;
import com.outdd.base.ResponseBase;
import com.outdd.dao.UserRepository;
import com.outdd.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
}
