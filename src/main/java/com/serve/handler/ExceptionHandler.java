package com.serve.handler;

import com.serve.pojo.common.Result;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public Result handleException(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new Result(Result.FAILURE_CODE, e.getMessage());
    }
}
