package com.lws.auth.constant;


import lombok.Getter;
import lombok.Setter;

public enum AccountEnum {

    ADMIN("admin", "admin");

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String pwd;

    AccountEnum(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public static boolean checkAccount(String userName, String pwd) {
        try {
            AccountEnum accountEnum = AccountEnum.valueOf(userName);
            return accountEnum.getPwd().equals(pwd);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}