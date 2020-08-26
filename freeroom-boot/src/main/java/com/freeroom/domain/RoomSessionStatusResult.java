package com.freeroom.domain;

import lombok.Data;

/**
 * @author 李发展
 * @date 2020-8-25 - 21:25
 * 教室节次状态返回信息
 */
@Data
public class RoomSessionStatusResult {
    private String session;
    private boolean free;

}
