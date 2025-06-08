package com.design.base.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class MyBatisUtils {
    
    private MyBatisUtils(){}//不能被实例化,属于单例模式的一种,单例模式有四种实现方式,请自学
    
    private final static String PATH = "mybatis-config.xml";
    
    private static SqlSessionFactory factory;

    private static InputStream is;
    
    static{
        try{
            is = Resources.getResourceAsStream(PATH);
            factory = new SqlSessionFactoryBuilder().build(is);
        }catch(IOException e){
            throw new RuntimeException("加载核心配置文件失败,原因为:"+e.getMessage());
        }
        
    }
    
    public static SqlSession getSqlSession(){
        return factory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    
}
