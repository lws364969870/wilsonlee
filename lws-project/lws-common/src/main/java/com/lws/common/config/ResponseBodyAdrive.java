package com.lws.common.config;

import com.lws.common.base.BaseResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author wilsonlee
 * @date 20191213
 */
//@ControllerAdvice
public class ResponseBodyAdrive implements ResponseBodyAdvice<Object> {

    public boolean supports(MethodParameter methodParameter, Class aClass) {
        if (aClass.isAssignableFrom(MappingJackson2HttpMessageConverter.class)) {
            return true;
        }
        if (aClass.isAssignableFrom(StringHttpMessageConverter.class)) {
            return true;
        }
        return false;
    }

    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class aClass,
        ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (aClass.isAssignableFrom(StringHttpMessageConverter.class)) {

        }
        if (null != object) {
            if (object instanceof BaseResponse) {
                return object;
            }
        }
        return BaseResponse.success(object);
    }
}
