package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author free
 * @version 1.0
 */
public class sqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    static{
        String config="mybatis.xml";
        try {

            InputStream is=Resources.getResourceAsStream(config);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession(){
         SqlSession sqlSession=null;
        if (sqlSessionFactory != null) {
             sqlSession=sqlSessionFactory.openSession();
        }
        return sqlSession;
    }
}
