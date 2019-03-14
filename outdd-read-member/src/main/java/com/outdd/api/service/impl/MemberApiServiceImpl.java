package com.outdd.api.service.impl;

import com.outdd.api.entity.UserEntity;
import com.outdd.api.service.MemberApiService;
import com.outdd.base.BaseApiService;
import com.outdd.base.ResponseBase;
import com.outdd.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
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
    MemberDao memberDao;
    @Override
    public ResponseBase findById(String id) {
        UserEntity user=memberDao.selectByPrimaryKey(id);
        ResponseBase responseBase = setResultError("没有该用户");
        if(user != null){
            responseBase = setResult(HTTP_RES_CODE_200,"",user);
        }
        return responseBase;
    }
}
