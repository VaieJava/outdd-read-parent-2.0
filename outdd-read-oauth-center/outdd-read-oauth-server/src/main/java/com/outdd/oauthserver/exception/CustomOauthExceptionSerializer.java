package com.outdd.oauthserver.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
 
/**
 * 
 * @ClassName:  CustomOauthExceptionSerializer   
 * @Description:password模式错误处理，自定义登录失败异常信息
 * @author: niugang
 * @date:   2018年9月5日 下午9:45:03   
 * @Copyright: 863263957@qq.com. All rights reserved. 
 *
 */
public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {
    
	private static final long serialVersionUID = 1478842053473472921L;
 
	public CustomOauthExceptionSerializer() {
        super(CustomOauthException.class);
    }
    @Override
    public void serialize(CustomOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        gen.writeStartObject();
        gen.writeStringField("error", String.valueOf(value.getHttpErrorCode()));
        gen.writeStringField("message", value.getMessage());
//      gen.writeStringField("message", "用户名或密码错误");
        gen.writeStringField("path", request.getServletPath());
        gen.writeStringField("timestamp", String.valueOf(new Date().getTime()));
       if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : 
            value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}