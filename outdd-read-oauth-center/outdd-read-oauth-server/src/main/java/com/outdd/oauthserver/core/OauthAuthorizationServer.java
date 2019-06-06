package com.outdd.oauthserver.core;

import com.outdd.oauthcommon.config.JwtToken;
import com.outdd.oauthserver.config.MyRedisTokenStore;
import com.outdd.oauthcommon.exception.AuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

import javax.sql.DataSource;

/**
 * 认证服务器
 *
 * @Date: 2018/4/8 10:48
 */
@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationServer extends AuthorizationServerConfigurerAdapter {
//
//    OAuth2AuthenticationProcessingFilter

    @Autowired
    private WebResponseExceptionTranslator customWebResponseExceptionTranslator;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    JwtToken jwtToken;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean("jdbcClientDetailsService")
    public JdbcClientDetailsService getJdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }


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
                .tokenKeyAccess("permitAll()")//isAuthenticated
                .checkTokenAccess("permitAll()")
                .authenticationEntryPoint(new AuthExceptionEntryPoint());

    }

    /**
     * 用于定义客户端详细信息服务的配置程序。可以初始化客户端详细信息，也可以只引用现有商店。
     * 配置OAuth2的客户端相关信息
     * @param clients a configurer that defines the client details service. Client details can be initialized, or you can just refer to an existing store.
     * @throws Exception exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //从数据库获取客户端信息
        clients.withClientDetails(getJdbcClientDetailsService());
        //加载客户端信息by内存
//        clients.inMemory()
//                .withClient("client")
//                .resourceIds(Constants.DEMO_RESOURCE_ID)
//                .authorizedGrantTypes("password","authorization_code","client_credentials", "refresh_token")
//                .authorities("client_1")
//                .secret("{noop}secret")
//                .scopes("all");
//                .accessTokenValiditySeconds(10000) //token过期时间
//                .refreshTokenValiditySeconds(10000); //refresh过期时间;
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
                .userDetailsService(userDetailsService)
                ;

        endpoints.exceptionTranslator(customWebResponseExceptionTranslator);//错误异常

    }


}