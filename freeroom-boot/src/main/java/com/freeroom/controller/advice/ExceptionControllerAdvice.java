package com.freeroom.controller.advice;

import com.freeroom.domain.result.APIException;
import com.freeroom.domain.result.ResultCode;
import com.freeroom.domain.result.ResultVo;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 李发展
 * @date 2020-8-25 - 18:14
 * 全局异常处理类
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 处理字段验证异常的处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo<>(ResultCode.VALIDATE_FAILED,objectError.getDefaultMessage());
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(APIException.class)
    public ResultVo<String> apiExceptionHandler(APIException e){
        return new ResultVo<>(ResultCode.FAILED, e.getMessage());
    }

}
