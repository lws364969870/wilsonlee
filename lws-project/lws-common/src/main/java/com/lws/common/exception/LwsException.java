package com.lws.common.exception;

import lombok.Data;

@Data
public class LwsException extends RuntimeException {

    public LwsException(String code) {
        super(code);
        setErrorCode(code);
    }

    private String errorCode;
    private String errorMessage;
    private String[] params;
}