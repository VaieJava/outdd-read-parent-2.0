package com.outdd.oauthcommon.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;
 
/**
 * 
 * @ClassName:  CustomWebResponseExceptionTranslator   
 * @Description:password模式错误处理，自定义登录失败异常信息
 * @author: niugang
 * @date:   2018年9月5日 下午9:46:36   
 * @Copyright: 863263957@qq.com. All rights reserved. 
 *
 */
@Component
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
 
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new CustomOauthException(oAuth2Exception.getMessage()));
    }
}