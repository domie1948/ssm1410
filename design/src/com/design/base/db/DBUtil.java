package com.design.base.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {
    /**单例模式:四种*/
    private DBUtil(){}

    /**常量用于连接数据库的信息*/
    private static final String USERNAME = "root";
    private static final String PASSWORD = "shxt";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/xy20_rbac";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    static{
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            throw new RuntimeException("加载驱动失败,原因为:"+e.getMessage());
        }
    }

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL , USERNAME , PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException("连接数据库失败,原因为:"+e.getMessage());
        }
    }
    
}
