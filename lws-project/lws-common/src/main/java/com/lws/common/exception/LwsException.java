package com.lws.common.exception;

import lombok.Data;

@Data
public class LwsException extends RuntimeException{

    private String errorCode;
    private String errorMessage;
    private String[] params;
}
