package com.freeclassroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * @author 李发展
 * @date 2020-8-23 - 17:34
 */
public class ToDataBase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/freeroom?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER_NAME = "root";
    static final String PASS = "root";

    public static void insertData(List<ClassRoom> list){
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("=======数据库连接======");
            conn = DriverManager.getConnection(DB_URL,USER_NAME,PASS);
            System.out.println("=====连接成功=======");
            statement = conn.createStatement();
            for (ClassRoom room : list) {
                List<Integer> schoolWeek = room.getSchoolWeek();
                for (Integer w : schoolWeek) {
                    String sql = "insert into room values(null,'"+room.getBuildingName()+"','"+room.getRoomName()
                            +"','"+room.getWeek()+"','"+room.getSession()+"',"+w+")";
                    int i = statement.executeUpdate(sql);
                    System.out.println(i);
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
