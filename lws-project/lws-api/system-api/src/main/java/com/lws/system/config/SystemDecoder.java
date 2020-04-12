package com.lws.system.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.lws.system.dto.SystemDto;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

//@ControllerAdvice
//public class SystemDecoder implements Decoder {
//
//    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
//        String body = Util.toString(response.body().asReader());
//        SystemDto javaBean = JSON.parseObject(body, new TypeReference<SystemDto>() {
//        });
//        javaBean.setCode("SystemDecoders");
//        return javaBean;
//    }
//}
