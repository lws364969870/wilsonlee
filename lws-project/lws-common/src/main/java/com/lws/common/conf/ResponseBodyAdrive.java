package com.lws.common.conf;

import com.lws.common.base.BaseResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局拦截
 *
 * @author wilsonlee
 * @date 20191213
 */
@ControllerAdvice
public class ResponseBodyAdrive implements ResponseBodyAdvice {


    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
s        if (o instanceof BaseResponse) {
            return o;
        }
        return BaseResponse.success(o);
    }
}
