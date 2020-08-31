package com.freeroom.service;

import com.freeroom.domain.BuildRoom;
import com.freeroom.domain.ClearBuildingRoomResult;
import com.freeroom.domain.RoomSessionStatusResult;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-25 - 21:30
 */
public interface FreeRoomService {

    /**
     * 查询具体教室的状态
     * @param buidName
     * @param roomName
     * @return
     */
    List<RoomSessionStatusResult> findRoomStatusByBuildAndRoom(String buidName, String roomName);


    /**
     * 扫楼
     * @param buildId
     * @param buildName
     * @return
     */
    List<ClearBuildingRoomResult> findByBuildingName(Integer buildId, String buildName);

    /**
     * 查询教学楼的luckyRoom
     * @param buildId
     * @param buildName
     * @return
     */
    List<BuildRoom>  findLuckyRoom(Integer buildId, String buildName);
}
