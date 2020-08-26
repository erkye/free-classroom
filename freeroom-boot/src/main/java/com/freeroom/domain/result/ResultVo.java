package com.freeroom.domain.result;

import lombok.Data;

/**
 * @author 李发展
 * @date 2020-8-25 - 18:08
 */
@Data
public class ResultVo<T> {
    /**
     * 状态码 1000 为成功
     */
    private int code;

    /**
     * 响应信息
     */
    private String message;
    /**
     * 相应数据
     */
    private T data;

    public ResultVo(T data){
        this(ResultCode.SUCCESS,data);

    }
    public ResultVo(ResultCode resultCode,T data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
