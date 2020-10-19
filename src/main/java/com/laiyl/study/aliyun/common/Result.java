package com.laiyl.study.aliyun.common;

import lombok.Data;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
public class Result<T> {

    private boolean success;

    private String msg;

    private String code;

    private T data;

    public static  <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        result.setMsg("success");
        result.setCode("200");
        return result;
    }

    public static  <T> Result<T> fail(String code, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(null);
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }
}
