package com.outdd.api.service;

import com.outdd.api.entity.UserEntity;
import com.outdd.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vaie
 * @Created 2019/1/26 17:45
 */
@RequestMapping("/member")
public interface MemberApiService {
    @RequestMapping("/findById")
    public ResponseBase findById(String id);
}
