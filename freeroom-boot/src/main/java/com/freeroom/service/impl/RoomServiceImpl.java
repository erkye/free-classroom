package com.freeroom.service.impl;

import com.freeroom.domain.BuildRoom;
import com.freeroom.domain.BuildRoomExample;
import com.freeroom.mapper.BuildRoomMapper;
import com.freeroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-25 - 20:25
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private BuildRoomMapper buildRoomMapper;


    @Override
    public List<BuildRoom> findByBuildId(int buildId) {
        BuildRoomExample example = new BuildRoomExample();
        BuildRoomExample.Criteria criteria = example.createCriteria();
        criteria.andBuildEqualTo(buildId);
        return buildRoomMapper.selectByExample(example);
    }
}
