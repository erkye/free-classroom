package com.freeroom.controller;

import com.freeroom.domain.BuildRoom;
import com.freeroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-25 - 20:24
 */
@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 查询是教学楼的所有教室
     * @param id
     * @return
     */
    @GetMapping("/findRooms")
    public List<BuildRoom> findRoomByBuildId(int id){
        return roomService.findByBuildId(id);
    }
}
