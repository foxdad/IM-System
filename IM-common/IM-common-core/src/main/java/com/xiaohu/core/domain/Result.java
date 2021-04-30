package com.xiaohu.core.domain;

import com.xiaohu.core.constant.Constants;
import lombok.Data;

import java.io.Serializable;

/**
 * @PackgeName: com.xiaohu.core.domain
 * @ClassName: Result
 * @Author: xiaohu
 * Date: 2021/4/30 15:27
 * @Description:
 */

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = Constants.SUCCESS;

    /** 失败 */
    public static final int FAIL = Constants.FAIL;

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> ok()
    {
        return restResult(null, Constants.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data)
    {
        return restResult(data, Constants.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data, String msg)
    {
        return restResult(data, Constants.SUCCESS, msg);
    }

    public static <T> Result<T> fail()
    {
        return restResult(null, Constants.FAIL, null);
    }

    public static <T> Result<T> fail(String msg)
    {
        return restResult(null, Constants.FAIL, msg);
    }

    public static <T> Result<T> fail(T data)
    {
        return restResult(data, FAIL, null);
    }

    public static <T> Result<T> fail(T data, String msg)
    {
        return restResult(data, Constants.FAIL, msg);
    }

    public static <T> Result<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> Result<T> restResult(T data, int code, String msg)
    {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
//
}
