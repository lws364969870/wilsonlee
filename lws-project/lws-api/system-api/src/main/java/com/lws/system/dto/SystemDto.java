package com.lws.system.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemDto<T> implements Serializable {

    private String code;
    private T data;
}
