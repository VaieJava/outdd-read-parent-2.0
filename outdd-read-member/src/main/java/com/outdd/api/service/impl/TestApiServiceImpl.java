package com.outdd.api.service.impl;

import com.outdd.api.service.TestApiService;
import com.outdd.base.BaseApiService;
import com.outdd.base.ResponseBase;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vaie
 * @Created 2019/1/26 14:51
 */
@RestController
public class TestApiServiceImpl extends BaseApiService implements TestApiService {
    @Override
    public Map<String, Object> qwe(Integer id, String name) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Code","200");
        result.put("id",id);
        result.put("name",name);
        return result;
    }

    @Override
    public ResponseBase testResp() {

        return setResultSuccess();
    }

    @Override
    public ResponseBase setRedis(Integer id, String name) {
        baseRedisService.setString("asd",id+""+name,null);
        return setResultSuccess();
    }
}
