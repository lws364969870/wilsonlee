package com.lws.generator.constant;

import lombok.Getter;
import lombok.Setter;

public enum ModulEnum {

    AUTH("auth", "lws-auth"),
    SYSTEM("system", "lws-system");

    /**
     * 模块名称
     */
    @Getter
    @Setter
    private String moduleName;

    /**
     * 路径
     */
    @Getter
    @Setter
    private String url;

    ModulEnum(String moduleName, String url) {
        this.moduleName = moduleName;
        this.url = url;
    }
}
