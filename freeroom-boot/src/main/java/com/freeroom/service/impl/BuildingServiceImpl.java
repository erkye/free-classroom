package com.freeroom.service.impl;

import com.freeroom.domain.Building;
import com.freeroom.mapper.BuildingMapper;
import com.freeroom.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-25 - 17:48
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> findAll() {
        return buildingMapper.selectByExample(null);
    }
}
