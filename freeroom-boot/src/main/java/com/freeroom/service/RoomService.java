package com.freeroom.service;

import com.freeroom.domain.BuildRoom;
import com.freeroom.domain.ClearBuildingRoomResult;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-25 - 20:25
 * 处理教学楼和房间的相关业务
 */
public interface RoomService {

    /**
     * 根据教学楼的id查询所有的教室
     * @param buildId
     * @return
     */
    List<BuildRoom> findByBuildId(int buildId);

}
