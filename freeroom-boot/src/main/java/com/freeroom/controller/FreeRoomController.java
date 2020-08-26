package com.freeroom.controller;

import com.freeroom.domain.ClearBuildingRoomResult;
import com.freeroom.domain.RoomSessionStatusResult;
import com.freeroom.service.FreeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-25 - 21:02
 */
@RestController
@CrossOrigin
@RequestMapping("/freeRoom")
public class FreeRoomController {

    @Autowired
    private FreeRoomService freeRoomService;

    @GetMapping("/queryRoom")
    public List<RoomSessionStatusResult> queryRoom(String buildingName, String roomName){
        return freeRoomService.findRoomStatusByBuildAndRoom(buildingName, roomName);
    }

    @GetMapping("/clearBuilding")
    public List<ClearBuildingRoomResult> clearBuilding(Integer buildingId,String buildingName){
        return freeRoomService.findByBuildingName(buildingId, buildingName);
    }
}
