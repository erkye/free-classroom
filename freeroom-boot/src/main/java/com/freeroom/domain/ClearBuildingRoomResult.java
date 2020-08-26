package com.freeroom.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-26 - 9:56
 */
@Data
public class ClearBuildingRoomResult {

    private String session;
    private List<BuildRoom> roomlist;

}
