package com.utah.bookretail.handler;

import com.utah.bookretail.common.Result;
import com.utah.bookretail.exception.BookretailException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BookretailExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req) {
        Result result = new Result();
        result.setResultCode(500);
        //区分是否为自定义异常
        if (e instanceof BookretailException) {
            result.setMessage(e.getMessage());
        } else {
            e.printStackTrace();
            result.setMessage("未知异常，请联系管理员");
        }
        return result;
    }
}
