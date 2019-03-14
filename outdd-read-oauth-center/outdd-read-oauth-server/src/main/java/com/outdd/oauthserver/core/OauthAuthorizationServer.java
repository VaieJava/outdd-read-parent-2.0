package com.outdd.oauthserver.core;

import com.outdd.constants.Constants;
import com.outdd.oauthcommon.config.JwtToken;
import com.outdd.oauthserver.config.MyRedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 认证服务器
 *
 * @Date: 2018/4/8 10:48
 */
@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationServer extends AuthorizationServerConfigurerAdapter {
//
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    JwtToken jwtToken;


    @Qualifier("myUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * 定义令牌端点上的安全性约 束
     * 配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     * @param security oauthServer defines the security constraints on the token endpoint.
     * @throws Exception exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

    /**
     * 用于定义客户端详细信息服务的配置程序。可以初始化客户端详细信息，也可以只引用现有商店。
     * 配置OAuth2的客户端相关信息
     * @param clients a configurer that defines the client details service. Client details can be initialized, or you can just refer to an existing store.
     * @throws Exception exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .resourceIds(Constants.DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password","client_credentials", "refresh_token")
                .authorities("client_1")
                .secret("{noop}secret")
                .scopes("all");
    }

    /**
     * 定义授权和令牌端点以及令牌服务
     * 配置AuthorizationServerEndpointsConfigurer众多相关类，包括配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
     * @param endpoints defines the authorization and token endpoints and the token services.
     * @throws Exception exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //指定token存储位置
                .tokenStore( new MyRedisTokenStore(redisConnectionFactory))
                //指定获取token的位置
                .accessTokenConverter(jwtToken.accessTokenConverter())
                //指定认证管理器
                .authenticationManager(authenticationManager)
                //用户账号密码认证
                .userDetailsService(userDetailsService);

    }


}