package com.freeroom.controller.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freeroom.domain.result.APIException;
import com.freeroom.domain.result.ResultVo;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 李发展
 * @date 2020-8-25 - 18:56
 * 相应数据统一封装类
 */
@RestControllerAdvice(basePackages = "com.freeroom.controller")
public class ResponseBodyControllerAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 是否需要包装 排除已经是统一返回类型的
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getParameterType().equals(ResultVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String 类型需要特殊处理
        if(methodParameter.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVo<>(o));
            } catch (JsonProcessingException e) {
                throw new APIException("返回String类型错误！");
            }
        }
        return new ResultVo<>(o);
    }
}
