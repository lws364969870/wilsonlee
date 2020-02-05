package com.lws.generator.constant;

import lombok.Getter;
import lombok.Setter;

public enum ModulEnum {

    AUTH("auth", "lws-auth", "com.lws"),
    SYSTEM("system", "lws-system", "com.lws");

    /**
     * 模块名称
     */
    @Getter
    private String moduleName;

    /**
     * 物理路径
     */
    @Getter
    private String url;

    /**
     * 包名称
     */
    @Getter
    private String pageageName;

    ModulEnum(String moduleName, String url, String pageageName) {
        this.moduleName = moduleName;
        this.url = url;
        this.pageageName = pageageName;
    }
}
