package com.bjpowernode.test;

import com.bjpowernode.bean.Student;
import com.bjpowernode.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author free
 * @version 1.0
 */
public class StudentTest01 {
    @Test
    public void test01() throws IOException {
//        //访问mybatis读取student数据
//        //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
//       String config="mybatis.xml";
//        //2.读取这个config表示的文件
//        InputStream is=Resources.getResourceAsStream(config);
//        //3.创建了SqlSessionFactoryBuilder对象
//      SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
//        //4.创建SqlSessionFactory对象
//      SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
//        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
//        //SqlSession sqlSession = factory.openSession();
//     SqlSession sqlSession= sqlSessionFactory.openSession(true);
//        //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
//      String sqlId="com.bjpowernode.dao.StudentDao.selectStudent";
//        //7. 重要】执行sql语句，通过sqlId找到语句
//        List<Student> student = sqlSession.selectList(sqlId);
//
//
//        //mybatis默认不是自动提交事务的， 所以在insert ，update ，delete后要手工提交事务
//        //sqlSession.commit();
//
//        //8.输出结果
//        for(Student s:student){
//            System.out.println(s);
//        }
//        //9.关闭SqlSession对象
//        sqlSession.close();

        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
//        String config="mybatis.xml";
//        //2.读取这个config表示的文件
//        InputStream in = Resources.getResourceAsStream(config);
//        //3.创建了SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
//        //4.创建SqlSessionFactory对象
//        SqlSessionFactory factory = builder.build(in);
//        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
//        //SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.bjpowernode.dao.StudentDao.selectStudent";
        //7. 重要】执行sql语句，通过sqlId找到语句
        List<Student> student = sqlSession.selectList(sqlId);

        //mybatis默认不是自动提交事务的， 所以在insert ，update ，delete后要手工提交事务
        //sqlSession.commit();

        //8.输出结果
        for (Student s:student){
            System.out.println(s);
        }

        //9.关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {

        SqlSession sqlSession= sqlSessionUtil.getSqlSession();
        String sqlId="com.bjpowernode.dao.StudentDao.insertStudent";
        Student student=new Student();
        student.setId(6);
        student.setName("张飞");
        student.setAge(29);
        student.setEmail("zhangfei@qq.com");
        int nums=sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
    }
}
