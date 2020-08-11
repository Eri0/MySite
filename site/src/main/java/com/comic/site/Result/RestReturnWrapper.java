package com.comic.site.Result;

import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RestReturnWrapper implements ResponseBodyAdvice<Object> {
    /**
     * 判定哪些请求要执行beforeBodyWrite，返回true执行，返回false不执行
     * */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        //获取当前处理请求的controller的方法
        //String methodName = methodParameter.getMethod().getName();
        // 拦/不拦截处理返回值的方法，如登录
        //String method = "login";
        //这里可以加入很多判定，如果在白名单的List里面，是否拦截
        return true;
    }


    /**
     * 返回前对body，request，response等请求做处理
     *
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param httpMessageConverter
     * @param serverHttpRequest
     * @param serverHttpResponse
     *
     * @return
     * */
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> httpMessageConverter,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        RestReturn restReturn = new RestReturn();
        if(body instanceof  RestReturn){
            return  (RestReturn)body;
        }
        else {
           return   restReturn.success(body,"");
        }
    }
}