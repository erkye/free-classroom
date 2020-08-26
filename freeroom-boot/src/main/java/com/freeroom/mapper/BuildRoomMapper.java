package com.freeroom.mapper;

import com.freeroom.domain.BuildRoom;
import com.freeroom.domain.BuildRoomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildRoomMapper {
    int countByExample(BuildRoomExample example);

    int deleteByExample(BuildRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuildRoom record);

    int insertSelective(BuildRoom record);

    List<BuildRoom> selectByExample(BuildRoomExample example);

    BuildRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuildRoom record, @Param("example") BuildRoomExample example);

    int updateByExample(@Param("record") BuildRoom record, @Param("example") BuildRoomExample example);

    int updateByPrimaryKeySelective(BuildRoom record);

    int updateByPrimaryKey(BuildRoom record);
}