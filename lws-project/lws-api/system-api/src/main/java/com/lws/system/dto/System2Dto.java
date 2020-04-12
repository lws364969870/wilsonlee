package com.lws.system.dto;

import lombok.Data;

@Data
public class System2Dto<T> {

    private String code;
    private T data;

}
