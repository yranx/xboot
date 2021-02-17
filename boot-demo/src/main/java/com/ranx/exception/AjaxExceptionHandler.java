package com.ranx.exception;

import com.ranx.utils.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ranx
 * @create 2018-04-10 23:42
 **/
@RestControllerAdvice
public class AjaxExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public JSONResult defaultErrorHandler(HttpServletRequest req,
                                          Exception e) throws Exception {
        e.printStackTrace();
        return JSONResult.errorException(e.getMessage());
    }
}
