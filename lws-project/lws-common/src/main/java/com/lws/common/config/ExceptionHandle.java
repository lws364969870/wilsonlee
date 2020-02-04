package com.lws.common.config;

import com.lws.common.base.BaseResponse;
import com.lws.common.constant.MessageEnum;
import com.lws.common.exception.LwsException;
import com.lws.common.utils.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(LwsException.class)
    public BaseResponse catchs(LwsException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(e.getErrorCode());
        baseResponse.setStackMsg("");
        StringBuffer sb = new StringBuffer();
        sb.append(e.getStackTrace()[10]);
        return baseResponse;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponse catchs(Exception e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(MessageEnum.E999.getCode());
        baseResponse.setMessage(MessageEnum.E999.getMessage());
        baseResponse.setStackMsg(ExceptionUtils.getStarckMessage(e));
        StringBuffer sb = new StringBuffer();
        sb.append(e.getStackTrace()[10]);
        return baseResponse;
    }
}
