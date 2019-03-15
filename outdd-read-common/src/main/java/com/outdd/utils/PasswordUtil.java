package com.outdd.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * TODO: 加密util
 * @author VAIE
 * @date: 2019/3/15-0:05
 * @version v1.0
 */
@Configuration
public class PasswordUtil {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static String getEncryptionPassword(String paw){
        return passwordEncoder().encode(paw);
    }
}
