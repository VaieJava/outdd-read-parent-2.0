package com.outdd.oauthserver.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 
 * @ClassName:  CustomOauthException   
 * @Description:password模式错误处理，自定义登录失败异常信息
 * @author: niugang
 * @date:   2018年9月5日 下午9:44:38   
 * @Copyright: 863263957@qq.com. All rights reserved. 
 *
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
    public CustomOauthException(String msg) {
        super(msg);
    }
}