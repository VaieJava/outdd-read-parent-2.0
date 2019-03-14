package com.outdd.api.service;

import com.outdd.base.ResponseBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author vaie
 * @Created 2019/1/25 17:53
 */
@RequestMapping("/1")
public interface TestApiService {
    @RequestMapping("/test")
    public Map<String,Object> qwe(Integer id,String name);

    @RequestMapping("/testResp")
    public ResponseBase testResp();

    @RequestMapping("/setRedis")
    public ResponseBase setRedis(Integer id,String name);


}
