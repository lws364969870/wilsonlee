package com.lws.common.constant;

import lombok.Getter;
import lombok.Setter;

public enum MessageEnum {

    E000("000", "成功"),
    E999("999", "失败");

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String message;

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
