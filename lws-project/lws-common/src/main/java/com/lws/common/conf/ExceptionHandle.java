package com.lws.common.conf;

import com.lws.common.base.BaseResponse;
import com.lws.common.exception.LwsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(LwsException.class)
    public BaseResponse catc(LwsException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(e.getErrorCode());
        baseResponse.setStackMsg("");
        StringBuffer sb = new StringBuffer();
        sb.append(e.getStackTrace()[10]);
        return baseResponse;
    }
}
