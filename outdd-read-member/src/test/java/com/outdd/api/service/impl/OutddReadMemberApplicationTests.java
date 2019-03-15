package com.outdd.api.service.impl;

import com.outdd.api.service.MemberApiService;
import com.outdd.base.ResponseBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutddReadMemberApplicationTests {

    @Autowired
    MemberApiService memberApiService;
    @Test
    public void contextLoads() {
        ResponseBase responseBase = memberApiService.findById("1");
        System.out.println(responseBase.toString());

    }

}

