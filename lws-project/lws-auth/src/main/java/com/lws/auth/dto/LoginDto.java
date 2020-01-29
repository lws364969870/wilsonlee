package com.lws.auth.dto;

import lombok.Data;

/**
 * 登录账号
 */
@Data
public class LoginDto {

    private String userName;
    private String pwd;
}
