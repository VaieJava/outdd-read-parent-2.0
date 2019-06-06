package com.outdd.oauth;

import com.outdd.constants.Constants;
import com.outdd.oauthcommon.exception.AuthExceptionEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class OauthResourceServer extends ResourceServerConfigurerAdapter {

    //资源安全配置
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {

        resources
                .resourceId(Constants.DEMO_RESOURCE_ID)//绑定客户端id
                .authenticationEntryPoint(new AuthExceptionEntryPoint())//无权限操作
                .stateless(true);
    }
    //http安全配置
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers().anyRequest()
                .and()
                .anonymous()
                .and()
                .authorizeRequests()
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                .antMatchers("/menu/**").authenticated();//配置order访问控制，必须认证过后才可以访问
        // @formatter:on
    }
}