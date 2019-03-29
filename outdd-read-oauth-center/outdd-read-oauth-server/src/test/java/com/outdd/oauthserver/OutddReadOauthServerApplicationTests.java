package com.outdd.oauthserver;

import com.outdd.oauthserver.feign.MemberApiServiceFeign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OutddReadOauthServerApplicationTests {

    @Autowired
    private MemberApiServiceFeign memberApiServiceFeign;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${server.port}")
    private String serverPort;
    public void setString(String key, Object data, Long timeout) {
        if (data instanceof String) {
            String value = (String) data;
            stringRedisTemplate.opsForValue().set(key, value);
        }
        if (timeout != null) {
            stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
    }
    @Test
    public void contextLoads() {
//        User user=memberApiServiceFeign.loadUserByUsername("admin");
//        System.out.println(user);
//        System.out.println("端口号为："+serverPort);
        System.out.println(passwordEncoder.encode("123456"));
        while (true) {

        }
    }

}
