package com.freeroom.service.impl;

import com.freeroom.domain.*;
import com.freeroom.mapper.BuildRoomMapper;
import com.freeroom.mapper.RoomMapper;
import com.freeroom.service.FreeRoomService;
import com.freeroom.util.SchoolTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 李发展
 * @date 2020-8-25 - 21:30
 */
@Service
public class FreeRoomServiceImpl implements FreeRoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private BuildRoomMapper buildRoomMapper;

    @Override
    public List<RoomSessionStatusResult> findRoomStatusByBuildAndRoom(String buidName, String roomName) {
        Date date = new Date();
        // 获取教学周
        int i = SchoolTimeUtil.getSchoolWeek(date);
        // 获取当天周几字符串表示
        String weekString = SchoolTimeUtil.getWeekString(date);

        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();
        criteria.andBuildnameEqualTo(buidName);
        criteria.andRoomEqualTo(roomName);
        criteria.andWeekEqualTo(weekString);
        criteria.andSchoolweekEqualTo(i);
        List<Room> roomList = roomMapper.selectByExample(example);
        // 生成一天的课表 默认教室所有节次都可以使用
        Map<Integer, RoomSessionStatusResult> map = getAllSessionList();
        // 遍历查询出来的当天教室的信息 将有课的节次状态修改为false
        for (Room room : roomList) {
            RoomSessionStatusResult result = map.get(room.getSession());
            result.setFree(false);
        }
        List<RoomSessionStatusResult> resultList = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            resultList.add(map.get(integer));
        }
        return resultList;
    }

    /**
     * 生成一天五大节可的map集合
     * @return
     */
    private Map<Integer,RoomSessionStatusResult> getAllSessionList(){
        Map<Integer,RoomSessionStatusResult> map = new HashMap<>();
        // 插入时间提示
        String[] time = new String[]{"(08:30-10:10)","(10:20-12:00)","(13:30-15:10)","(15:20-17:00)","(19:00-20:40)"};
        for(int i=1;i<=5;i++){
            RoomSessionStatusResult result = new RoomSessionStatusResult();
            result.setSession("第"+ i +"大节" + time[i-1]);
            result.setFree(true);
            map.put(i,result);
        }
        return map;
    }

    @Override
    public List<ClearBuildingRoomResult> findByBuildingName(Integer buildId, String buildName) {
        // 查询该教学楼的所有教室列表
        BuildRoomExample example = new BuildRoomExample();
        BuildRoomExample.Criteria criteria = example.createCriteria();
        criteria.andBuildEqualTo(buildId);
        List<BuildRoom> buildRoomList = buildRoomMapper.selectByExample(example);
        Map<Integer, ClearBuildingRoomResult> map = getClearBuildingList(buildRoomList);

        // 查询教室记录
        Date date = new Date();
        int schoolWeek = SchoolTimeUtil.getSchoolWeek(date);
        String weekString = SchoolTimeUtil.getWeekString(date);
        RoomExample example1 = new RoomExample();
        RoomExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andBuildnameEqualTo(buildName);
        criteria1.andWeekEqualTo(weekString);
        criteria1.andSchoolweekEqualTo(schoolWeek);
        List<Room> rooms = roomMapper.selectByExample(example1);

        for (Room room : rooms) {
            ClearBuildingRoomResult clearBuildingRoomResult = map.get(room.getSession());
            List<BuildRoom> roomlist = clearBuildingRoomResult.getRoomlist();
            Iterator<BuildRoom> iterator = roomlist.iterator();
            while(iterator.hasNext()){
                if(room.getRoom().equals(iterator.next().getName())){
                    iterator.remove();
                    break;
                }
            }
        }
        List<ClearBuildingRoomResult> resultList = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            resultList.add(map.get(integer));
        }


        return resultList;
    }

    @Override
    public List<BuildRoom> findLuckyRoom(Integer buildId, String buildName) {

        List<BuildRoom> result = new ArrayList<>();

        // 查询该教学楼的所有教室
        BuildRoomExample buildRoomExample = new BuildRoomExample();
        BuildRoomExample.Criteria criteria = buildRoomExample.createCriteria();
        criteria.andBuildEqualTo(buildId);
        List<BuildRoom> roomList = buildRoomMapper.selectByExample(buildRoomExample);


        // 查询所有教室的每节课的状态
        for (BuildRoom room : roomList) {
            // 标记该教室是否是当前全部空闲
            boolean flag = true;
            // 获取该教室当天的每节课的信息
            List<RoomSessionStatusResult> roomStatus = findRoomStatusByBuildAndRoom(buildName, room.getName());
            for (RoomSessionStatusResult status : roomStatus) {
                // 如果当天的课表信息中有不可用的 将标记改为false
                if(!status.isFree()){
                    flag = false;
                }
            }
            // 如果该教室全天都是空闲的 添加该教室
            if(flag){
                result.add(room);
            }
        }

        return result;

    }

    private Map<Integer,ClearBuildingRoomResult> getClearBuildingList(List<BuildRoom> roomList){
        Map<Integer,ClearBuildingRoomResult> map = new HashMap<>();
        // 上课时间提示
        String[] time = new String[]{"(08:30-10:10)","(10:20-12:00)","(13:30-15:10)","(15:20-17:00)","(19:00-20:40)"};
        for(int i=1;i<=5;i++){
            List<BuildRoom> list = new ArrayList<>(roomList);
            ClearBuildingRoomResult result = new ClearBuildingRoomResult();
            result.setSession("第"+ i +"大节" + time[i-1]);
            result.setRoomlist(list);
            map.put(i,result);
        }
        return map;
    }



}
