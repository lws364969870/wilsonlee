package com.lws.generator.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 数据源配置工具
 */
@Slf4j
public class DatasourcePropertiesUtils {

    private static Properties props;

    static {
        String fileName = "datasource.properties";
        props = new Properties();
        try {
            props.load(
                new InputStreamReader(DatasourcePropertiesUtils.class.getClassLoader().getResourceAsStream(fileName),
                    "UTF-8"));
        } catch (IOException e) {
            log.error("配置文件读取异常");
        }
    }

    //自定义俩个get方法，方便调用工具类读取properties文件的属性
    public static String getProperty(String key) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key, String defaultValue) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }
}
