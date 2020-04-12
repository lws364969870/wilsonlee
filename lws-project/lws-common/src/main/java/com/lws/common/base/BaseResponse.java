package com.lws.common.base;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse implements Serializable {

    private String code;
    private Object data;
    private String message;
    private String stackMsg;

    public static BaseResponse success(Object o) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("0");
        baseResponse.setData(o);
        return baseResponse;
    }
}

