package com.comic.site;

import com.comic.site.Result.RestReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody // 拦截返回是 json返回结果
    public RestReturn exceptionHandler(Exception e, HttpServletRequest request) {
        log.error(request.getRequestURI().toString());
        log.error(e.getMessage(),e);
        RestReturn restReturn = new RestReturn();
       return   restReturn.error(404,null,e.getMessage());

    }
}
