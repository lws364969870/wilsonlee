package com.lws.system.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Data
public class SystemDto<T> implements Serializable {

    private String code;

    private T data;

    private Class<T> clazz;

    // 使用反射技术得到T的真实类型
    public Class getRealType(){
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        return clazz;
    }


    public T getJSONData() {
        System.out.println(getRealType().getName());

        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(data.getClass().getDeclaringClass()));
        return (T) JSON.toJavaObject(jsonObject, data.getClass().getDeclaringClass());
    }
}
