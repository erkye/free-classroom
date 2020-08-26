package com.freeclassroom;

import java.io.IOException;
import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-23 - 9:21
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
            ParsingHTML parsingHTML = new ParsingHTML("F:\\idea_workingspace\\free-classroom\\retrieve-data\\src\\main\\resources\\data.html");
            List<ClassRoom> roomList = parsingHTML.getClassRoomList();
            ToDataBase.insertData(roomList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
