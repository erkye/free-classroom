package com.freeroom.domain.result;

import lombok.Data;

/**
 * @author 李发展
 * @date 2020-8-25 - 18:20
 * 自定义异常
 */
@Data
public class APIException extends RuntimeException{
    private int code;
    private String message;

    public APIException(){
        this("接口错误！");
    }
    public APIException(String message){
        this(1001,message);
    }

    public APIException(int code,String message){
        this.code = code;
        this.message = message;
    }
}
