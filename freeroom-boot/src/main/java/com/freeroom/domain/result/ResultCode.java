package com.freeroom.domain.result;

import lombok.Getter;

/**
 * @author 李发展
 * @date 2020-8-25 - 18:31
 * 异常枚举类
 */
@Getter
public enum ResultCode {
    /**
     * 成功 失败 参数校验失败 未知错误
     */
    SUCCESS(1000,"一切正常！"),
    FAILED(1001,"响应出错了！请联系那个写bug的家伙！"),
    VALIDATE_FAILED(1002,"参数校验失败！请联系那个写bug的家伙！"),
    ERROR(5000,"未知异常！这次写bug的家伙也没办法了！");

    private int code;
    private String message;

    ResultCode(int code,String message){
        this.code = code;
        this.message = message;
    }
}
