package com.freeclassroom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-23 - 9:21
 */
public class ParsingHTML {

    private File file = null;

    private String filePath;

    private Document document = null;

    private List<ClassRoom> classRoomList;

    public ParsingHTML(String path) throws IOException {
        this.filePath = path;
        loadFile();
        classRoomList = new ArrayList<>();
        parse();
    }

    public List<ClassRoom> getClassRoomList() {
        return classRoomList;
    }

    private void parse() throws IOException {
        document = Jsoup.parse(file, "UTF-8");
        // 读取每一行的数据
        Elements trs = document.select("tbody>tr");

        for (Element tr : trs) {
            Elements tds = tr.select("td>nobr");

            // 读取第一列 教学楼名称和教室名称
            String text1 = tds.get(0).text();
            String[] s1 = text1.split(" ");
            String buildName = s1[0];
            String roomName = s1[1];


            String[] weeks = new String[]{"周一","周二","周三","周四","周五","周六","周天"};
            // 周下标
            int week_index = 0;
            // 节次
            int session = 0;

            for(int i=1;i<tds.size();i++){

                // 多个班级
                Elements clazzs = tds.get(i).select("div");
                for (Element  clazz: clazzs) {
                    // 设置教学楼名称和教室名称
                    ClassRoom classRoom = new ClassRoom();
                    classRoom.setBuildingName(s1[0]);
                    classRoom.setRoomName(s1[1]);
                    classRoom.setWeek(weeks[week_index]);
                    classRoom.setSession(session+1);
                    //System.out.println(clazz.text());
                    String[] strings = clazz.text().split("周\\)");
                    //System.out.println(strings[0]);
                    // 001168-040229G 交通系统分析 刘杰,张勇,亓伟 (7-14
                    String weekString = strings[0].substring(strings[0].lastIndexOf('(')+1);
                    //System.out.println(weekString);
                    List<Integer> list = parseWeekString(weekString);

                    classRoom.setSchoolWeek(list);
                    //System.out.println(list);

                    // 添加到数组中
                    classRoomList.add(classRoom);
                }

                if((session+1)%5 == 0){
                    week_index++;
                }
                session = (session + 1)%5;

            }

        }

        System.out.println(classRoomList);


    }

    private void loadFile(){
        if(file == null){
            file = new File(filePath);
        }
    }

    private List<Integer> parseWeekString(String str){
        List<Integer> list = new ArrayList<>();

        String[] strings = str.split(",");
        // 两种 10-17  或者 10
        for (String s : strings) {
            if(s.indexOf('-') < 0){
                // 10
                list.add(Integer.parseInt(s));
            }else{
                // 10-17
                String[] split = s.split("-");
                int begin = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                for(int i=begin;i<= end;i++){
                    list.add(i);
                }
            }
        }

        return list;
    }

}
