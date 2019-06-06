//package com.outdd.oauthserver.config;
//
//import com.outdd.oauthserver.exception.LLGAuthenticationEntryPoint;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public abstract class ResServerConfig extends ResourceServerConfigurerAdapter {
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
//
//        resources.authenticationEntryPoint(new LLGAuthenticationEntryPoint());
//
//    }
//}
