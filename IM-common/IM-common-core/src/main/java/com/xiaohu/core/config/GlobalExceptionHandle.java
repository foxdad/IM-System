package com.xiaohu.core.config;

import com.xiaohu.core.domain.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @PackgeName: com.xiaohu.core.config
 * @ClassName: GlobalExection
 * @Author: xiaohu
 * Date: 2021/5/6 14:18
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandle {


    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    public Result exceptionHandler(Exception e){

        return Result.fail(e,"全局异常发生了");
    }

}
